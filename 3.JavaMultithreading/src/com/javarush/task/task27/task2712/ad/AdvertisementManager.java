package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> videos;
    private int timeSeconds;
    private long maxProfit = 0;
    private int minRemainingTime = timeSeconds;

    public AdvertisementManager(int timeSeconds) {

        this.timeSeconds = timeSeconds;
        videos = new ArrayList<>();
        for(Advertisement ad: storage.list()){
            if(ad.getHits() > 0){
                videos.add(ad);
            }
        }

    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();
        List<Advertisement> bestVariant = new ArrayList<>();
        bestVariant = pickVideosToList(null, null, timeSeconds, 0, bestVariant);
        long totalAmount = 0;
        int totalDuration = 0;
        for (Advertisement ad : bestVariant) {
            ad.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(),
                    ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
        }
    }
    private List<Advertisement> pickVideosToList(List<Advertisement> previousList, Advertisement previousAd, int remainingTime,
                                                 long profit, List<Advertisement> bestResult) throws NoVideoAvailableException {
        List<Advertisement> newList = new ArrayList<>();
        if (previousList != null) {
            newList.addAll(previousList);
            remainingTime -= previousAd.getDuration();
            profit += previousAd.getAmountPerOneDisplaying();
            newList.add(previousAd);
        }
        for (Advertisement ad : videos) {
            if (remainingTime == 0) break;
            if (newList.contains(ad)) continue;
            if (ad.getHits() <= 0) continue;
            if (remainingTime >= ad.getDuration()) bestResult = pickVideosToList(newList, ad, remainingTime, profit, bestResult);
        }
        if (profit > maxProfit) {
            maxProfit = profit;
            minRemainingTime = remainingTime;
            bestResult = newList;
        } else if (profit == maxProfit && remainingTime < minRemainingTime) {
            minRemainingTime = remainingTime;
            bestResult = newList;
        } else if (profit == maxProfit && remainingTime == minRemainingTime && bestResult.size() > newList.size())
            bestResult = newList;

        Collections.sort(bestResult, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (pricePerVideoDiff != 0)
                    return (int) pricePerVideoDiff;
                else
                    return (int) (o1.getAmountPerOneDisplaying() * 100 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 100 / o2.getDuration());
            }
        });
        return bestResult;
    }

    public static void main(String[] args) {
        AdvertisementManager am = new AdvertisementManager(3000);
        AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
        advertisementStorage.list().clear();

        Object content = new Object();

        Advertisement a1 = new Advertisement(content, "Video1", 100, 0, 25 * 60);
        Advertisement a2 = new Advertisement(content, "Video2", 200, 2, 6 * 60);

        advertisementStorage.list().add(a1);
        advertisementStorage.list().add(a2);

        am.processVideos();
    }
}

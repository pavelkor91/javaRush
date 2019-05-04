package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.List;

public class AdvertisementManager {
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> bestItems = null;
    private long bestPrice;
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();
    }

    private int calcDuration(List<Advertisement> ads){
        int duration = 0;
        for(Advertisement ad: ads){
            duration += ad.getDuration();
        }
        return duration;
    }

    private long calcPrice(List<Advertisement> ads){
        int totalPrice = 0;
        for(Advertisement ad: ads){
            totalPrice += ad.getAmountPerOneDisplaying();
        }
        return totalPrice;
    }


}

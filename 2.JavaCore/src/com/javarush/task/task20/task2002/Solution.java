package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("E:\\javarush\\JavaRushTasks\\resources\\file.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setLastName("Blad");
            user.setFirstName("Aren");

            User user2 = new User();
            user.setCountry(User.Country.UKRAINE);
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setLastName("Blad2");
            user.setFirstName("Aren2");

            javaRush.users.add(user);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(loadedObject.equals(javaRush)){
                System.out.println("Равны");
            }
            else {
                System.out.println("Неравно");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            for(User user: users){
               String firstName =  user.getFirstName() == null ? "Null\n" : user.getFirstName()+"\n";
               outputStream.write(firstName.getBytes());

               String lastName =  user.getLastName() == null ? "Null\n" : user.getLastName()+"\n";
               outputStream.write(lastName.getBytes());

               String birthDate = user.getBirthDate() == null ? "Null\n" : user.getBirthDate().getTime() + "\n";
               outputStream.write(birthDate.getBytes());

               String isMale = user.isMale() == true ? "True\n" : "False\n";
               outputStream.write(isMale.getBytes());

               String country = user.getCountry() == null ? "Null\n" : user.getCountry().name()+"\n";
               outputStream.write(country.getBytes());

            }
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()){
                User user = new User();
                String s;
                user.setFirstName((s = bufferedReader.readLine()).equals("Null") ? null : s);
                user.setLastName((s = bufferedReader.readLine()).equals("Null") ? null : s);
                user.setBirthDate((s = bufferedReader.readLine()).equals("Null") ? null : new Date(Long.parseLong(s)));
                user.setMale(bufferedReader.readLine().equals("True") ? true : false);
                if ((s = bufferedReader.readLine()).equals("Null")){
                    user.setCountry(null);
                }
                else {
                    user.setCountry(User.Country.valueOf(s));
                }
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

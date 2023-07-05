package com.example.demo.util;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public class Util {

    private static Faker faker = new Faker();

    public static String getFakeFirstName(){

        return faker.name().firstName();

    }

    public static String getFakeFullName(){

        return faker.name().fullName();

    }
    public static String getFakeAddress(){

        return faker.address().fullAddress();

    }


    public static LocalDateTime getLocalDateTime(){

        DateAndTime dateAndTime = faker.date();

        LocalDateTime localDateTime = dateAndTime
                .birthday()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();


        return localDateTime;

    }


    public static int getFakeAge() {

        Random r = new Random();
        int low = 18;
        int high = 88;
        int age = r.nextInt(high - low) + low;
        return age;
    }

}


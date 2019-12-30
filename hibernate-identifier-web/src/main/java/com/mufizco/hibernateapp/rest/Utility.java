package com.mufizco.hibernateapp.rest;

import java.util.Random;

public class Utility {

    protected static int getRandomInt(){
        Random random = new Random();
        return random.nextInt(10000);
    }
}

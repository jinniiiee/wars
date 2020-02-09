package com.isha.prepare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PracticeChallenge {
    // Complete this function to return either
    // "Hello, [name]!" or "Hello there!"
    // based on the input

    public static String sayHello( String name ) {
        // You can print to STDOUT for debugging if you need to:
        String displayName = "Hello, " + name + "!";
        if(name == null || name.isEmpty()){
            displayName = "Hello there!";
        }
        //    System.out.print();

        // but you need to return the correct value in order to pass the challenge

        return displayName; // TODO: return the correct value
    }


}

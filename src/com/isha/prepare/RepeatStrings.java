package com.isha.prepare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatStrings {
    public static void main(String[] args) {
        String s = "a";
        long n = 1000000000000l;
        long occurrences = 0l;
        List pushString = s.codePoints().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
        int initFrequency = Collections.frequency(pushString, "a");
        int sizePatrnString = pushString.size();
        long repeatCount = n / sizePatrnString;
        long leftCount = n % sizePatrnString;
        for(int i = 0; i < leftCount; i++){
            if(pushString.get(i).toString().equals("a")){
                occurrences++;
            }
        }
        long times = (initFrequency * repeatCount) + occurrences;
        System.out.println(times);
    }
}

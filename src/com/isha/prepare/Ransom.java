package com.isha.prepare;

import java.util.Arrays;
import java.util.List;

public class Ransom {
    public static void main(String[] args){
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};
        int m = magazine.length;
        int n = note.length;
        List magazineNotes = Arrays.asList(magazine);
        List ransomNotes = Arrays.asList(note);
        for(Object findWord : ransomNotes){
            magazineNotes.stream().filter(magazineWord -> findWord.toString().equalsIgnoreCase(magazineWord.toString())).findFirst();
        }
    }
}

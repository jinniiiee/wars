package com.isha.prepare.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CreateTelephoneNumbers {
    public static void main(String [] args){
        createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }

    public static String createPhoneNumber(int[] numbers) {
        if(numbers.length != 10){
            return "";
        }
        int[] countryCode = Arrays.copyOfRange(numbers, 0, 3);
        int[] prefix = Arrays.copyOfRange(numbers, 3, 6);
        int[] suffix = Arrays.copyOfRange(numbers, 6, 10);
        String first = Arrays.stream(countryCode).mapToObj(String::valueOf).collect(Collectors.joining(""));
        String second = Arrays.stream(prefix).mapToObj(String::valueOf).collect(Collectors.joining(""));
        String third = Arrays.stream(suffix).mapToObj(String::valueOf).collect(Collectors.joining(""));
        String phoneNumber = String.format("(%s) %s-%s", first, second, third);
        return phoneNumber;
    }
}

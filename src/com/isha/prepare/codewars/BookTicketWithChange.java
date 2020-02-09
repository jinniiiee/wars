package com.isha.prepare.codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookTicketWithChange {
    public static void main(String [] args){
        System.out.println(Tickets(new int[] {25, 25, 50})); // => YES
        System.out.println(Tickets(new int[]{25, 100})); // => NO. Vasya will not have enough money to give change to 100 dollars
        System.out.println(Tickets(new int[] {25, 25, 50, 50, 100})); // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
    }

    public static String Tickets(int[] peopleInLine)
    {
        List people = IntStream.of(peopleInLine).boxed().collect(Collectors.toList());
        System.out.println(people.toString());
        int twoFiveBills = 0;
        int fiftyBills = 0;
        boolean noChange = false;
        for(int i = 0; i < peopleInLine.length; i++){
            if(peopleInLine[i] == 25){
                twoFiveBills++;
            }
            if(peopleInLine[i] == 50){
                fiftyBills++;
                if(--twoFiveBills < 0){
                    noChange = true;
                    break;
                }
            }
            if(peopleInLine[i] == 100){
                if(fiftyBills-1 < 0 && twoFiveBills-3 < 0){
                    noChange = true;
                    break;
                }else if(fiftyBills-1 >= 0 && twoFiveBills-1 < 0){
                    noChange = true;
                    break;
                }
                if(fiftyBills-1 >=0){
                    fiftyBills--;
                    twoFiveBills--;
                }else {
                    twoFiveBills -= 3;
                }
            }
        }
        return noChange?"NO":"YES";
    }
}

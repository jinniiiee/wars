package com.isha.prepare.uc;

import java.util.*;
import java.util.stream.IntStream;

public class SplitPACWay {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int trips = 0;
        int numberOfItems = 0;
        do {
            numberOfItems = scanner.nextInt();
            int [] weights = new int[numberOfItems];
            readWeights(scanner, numberOfItems, weights);
            int sum = IntStream.of(weights).sum();
            Map record = new TreeMap();
            if(weights.length == 0){
                return;
            }
            for (int i = 0; i < numberOfItems-1; i++) {
                splitWeight(numberOfItems, weights, record, i, sum);
            }
            if (!record.isEmpty()) {
                Iterator valuesIt = record.values().iterator();
                while(valuesIt.hasNext()) {
                    System.out.println(valuesIt.next());
                }
            }
            trips++;
        } while (numberOfItems != 0 && trips <= 150);
    }

    private static void readWeights(Scanner scanner, int numberOfItems, int [] weights) {
        for (int i = 0; i < numberOfItems; i++) {
            if(numberOfItems >= 1 && numberOfItems <= 20) {
                weights[i] = scanner.nextInt();
            }
        }
        //Arrays.sort(weights);
    }

    private static void splitWeight(int numberOfItems, int [] weights, Map record, int i, int totalSum) {
        System.out.println("Total sum :"+totalSum);
        System.out.println("i :"+i);
        //int firstStart = i;
        //int firstEnd = numberOfItems-2;
        int firstEnd = i;

        int secondSum = 0;
        int diff = 0;
        do {
            int firstSum = 0;
            for (int x = i; x <= firstEnd; x++) {
                firstSum += weights[x];
                //System.out.println("firstEnd: "+firstEnd+"with i: "+i);
                System.out.println("element to be added "+weights[x]+"with firstSum: "+firstSum);
            }
            secondSum = totalSum - firstSum;
            if (firstSum < secondSum) {
                diff = secondSum - firstSum;
            } else {
                diff = firstSum - secondSum;
            }
            record.put(diff, Arrays.asList(firstSum, secondSum));
            firstEnd++;
            System.out.println("*******************************");
        }while(firstEnd < numberOfItems);
    }
}

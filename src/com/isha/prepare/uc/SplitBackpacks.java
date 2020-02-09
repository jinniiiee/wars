package com.isha.prepare.uc;

import java.util.*;

public class SplitBackpacks {
    public static void main(String args []){
        Scanner scanner = new Scanner(System.in);
        int trips = 0;
        while(scanner.hasNextInt()) {
            int numberOfItems = 0;
            do {
                numberOfItems = scanner.nextInt();
                List<Integer> weightList = new ArrayList<>();
                readWeights(scanner, numberOfItems, weightList);
                Map record = new TreeMap();
                if(weightList.isEmpty()){
                    return;
                }
                for (int i = 0; i < numberOfItems; i++) {
                    System.out.println(i);
                    splitWeight(numberOfItems, weightList, record, i);
                }
                if (!record.isEmpty()) {
                    List values = (List) record.values().iterator().next();
                    System.out.println(values);
                }
                if(weightList.size() > 2){}
                trips++;
            } while (numberOfItems != 0 && trips <= 150);
        }
    }

    private static void splitBags(int [] weightList, int leftRoot, int rightRoot) {
        for(int x=0; x < weightList.length-2; x++){

            int numberToAdd = weightList[x];
            int fillLeft = leftRoot+numberToAdd;
            int fillRight = rightRoot+numberToAdd;
            int leftDiff = 0;
            int rightDiff = 0;
            if(fillLeft > rightRoot){
                leftDiff = fillLeft - rightRoot;
            }else{
                leftDiff = rightRoot - fillLeft;
            }
            if(fillRight > leftRoot){
                rightDiff = fillRight - leftRoot;
            }else{
                rightDiff = leftRoot - fillRight;
            }
            if(leftDiff < rightDiff){
                leftRoot = fillLeft;
                System.out.println("leftfill"+numberToAdd);
            }else{
                rightRoot = fillRight;
                System.out.println("rightFill"+numberToAdd);
            }
        }
        System.out.println(leftRoot);
        System.out.println(rightRoot);
        System.out.println("***************");
    }

    private static void readWeights(Scanner scanner, int numberOfItems, List<Integer> weightList) {
        for (int i = 0; i < numberOfItems; i++) {
            if(numberOfItems >= 1 && numberOfItems <= 20) {
                weightList.add(scanner.nextInt());
            }
        }
        //weightList.sort(Comparator.naturalOrder());
    }

    private static void splitWeight(int numberOfItems, List<Integer> weightList, Map record, int i) {
        int firstEnd = i;
        int secondStart = i+1;
        int firstSum = 0;
        int secondSum = 0;
        int diff = 0;
        for(int x = 0; x <= firstEnd; x++){
            Integer weight = (Integer)weightList.get(x);
            //System.out.println("xW"+weight);
            firstSum += weight.intValue();
        }
        for(int y = secondStart; y < numberOfItems; y++){
            Integer weight = (Integer)weightList.get(y);
            //System.out.println("yW"+weight);
            secondSum += weight.intValue();
        }
        if(firstSum < secondSum){
            diff = secondSum - firstSum;
        }else{
            diff = firstSum - secondSum;
        }
        record.put(diff, Arrays.asList(firstSum, secondSum));
    }
}


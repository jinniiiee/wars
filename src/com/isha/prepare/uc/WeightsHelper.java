package com.isha.prepare.uc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WeightsHelper {
    private int [] weights;
    private int numberOfItems;
    private int sum;
    private int minDiff;
    private int bestOption;

    public int getBestOption() {
        return bestOption;
    }

    public void setBestOption(int bestOption) {
        int median = sum/2;
        int oldMinDiff = getMinDiff();
        int newMinDiff;
        if(bestOption < median){
            newMinDiff = median - bestOption;
        }else{
            newMinDiff = bestOption - median;
        }
        if(oldMinDiff == -1 || newMinDiff < oldMinDiff) {
            setMinDiff(newMinDiff);
            this.bestOption = bestOption;
        }
    }

    public WeightsHelper(int numberOfItems){
        weights = new int[numberOfItems];
        this.numberOfItems = numberOfItems;
        minDiff = -1;
        bestOption = 0;
    }

    public int getWeightValue(int index){
        return index < numberOfItems ? weights[index] : -1;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getMinDiff() {
        return minDiff;
    }

    public void setMinDiff(int minDiff) {
        this.minDiff = minDiff;
    }

    public void setWeights(int index, int value){
        weights[index] = value;
    }
    public void sortWeights(){
        Arrays.sort(weights);
    }
    public int getSum(){
        return sum;
    }

    public void setSum(){
        sum = IntStream.of(weights).sum();
    }
}

package com.isha.prepare;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Socks {
    public static void main(String arr[]){
        int [] ar = {1,2,1,2,1,2,3};
        int n=7;
        int noOfPairs = 0;
        Set colSet = IntStream.of(ar).boxed().collect(Collectors.toSet());
        List colList = IntStream.of(ar).boxed().collect(Collectors.toList());
        System.out.println("No of colors : "+colSet.size());
        for (Object colSetVal : colSet){
            int noOfSock = Collections.frequency(colList, colSetVal);
            System.out.println("noOfSock:"+noOfSock);
            int eachPair = noOfSock / 2;
            System.out.println("Pair:"+eachPair);
            noOfPairs += eachPair;
        };
        System.out.println("Total Pair:"+noOfPairs);
    }
}

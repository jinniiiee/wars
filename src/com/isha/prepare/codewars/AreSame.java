package com.isha.prepare.codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if(a == null || b == null || a.length != b.length || a.length == 0){
            return false;
        }
        for(int i=0;  i< b.length; i++){
            double matchValues = Math.sqrt((double)b[i]);
            int removeIndex = -1;
            System.out.println(IntStream.of(a).boxed().collect(Collectors.toList()));
            for(int j =0; j< a.length; j++){
                if(matchValues == a[j]){
                    System.out.println("match found"+matchValues);
                    removeIndex = j;
                    break;
                }
            }
            if(removeIndex == -1){
                return false;
            }
            List<Integer> arrayList = IntStream.of(a).boxed().collect(Collectors.toList());
            arrayList.remove(removeIndex);
            a = arrayList.stream().mapToInt(Integer::intValue).toArray();
            System.out.println(IntStream.of(a).boxed().collect(Collectors.toList()));
        }
        return true;
    }
}

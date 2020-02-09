package com.isha.prepare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Valleys {
    public static void main(String arr[]){
        int step = 0;
        String trail = "UDDDUDUUDUDU";
        List trailList = trail.codePoints().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
        List trailSteps = new ArrayList();
        System.out.println(trailList);
        for(Object stepTaken : trailList){
            if(stepTaken.equals("U")){
                step += 1;
            }else{
                step -= 1;
            }
            trailSteps.add(step);
        }
        System.out.println(trailSteps);
        int seaSteps = Collections.frequency(trailSteps, 0);
        long count = IntStream.range(1, trailSteps.size()).filter(i -> trailSteps.get(i).equals(0) && trailSteps.get(i-1).equals(-1)).count();
        System.out.println("No of valleys:"+count);
    }
}

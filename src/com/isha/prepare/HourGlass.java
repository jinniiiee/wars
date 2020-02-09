package com.isha.prepare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HourGlass {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,0,0,0},
                       {0,1,0,0,0,0},
                       {1,1,1,0,0,0},
                       {0,0,2,4,4,0},
                       {0,0,0,2,0,0},
                       {0,0,1,2,4,0}};
        int x = arr[0].length;
        int y = arr.length;
        List hgSum = new ArrayList();
        for(int i=0; i < y-1; i++){
            for(int j=0; j < x-1; j++){
                if((i+2 < x) && (j+2 < y)){
                    System.out.println("i:"+i+" and j:"+j);
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    System.out.println(arr[i][j]+","+arr[i][j+1] + "," +arr[i][j+2] + "," +arr[i+1][j+1] + "," +arr[i+2][j] + "," +arr[i+2][j+1] + "," +arr[i+2][j+2]);
                    hgSum.add(sum);
                }
            }
        }
        System.out.println(hgSum.toString());
        List sortedSum = (List) hgSum.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(Integer.parseInt(sortedSum.get(0).toString()));

    }
}

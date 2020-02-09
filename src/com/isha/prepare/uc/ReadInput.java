package com.isha.prepare.uc;

import java.util.ArrayList;
import java.util.List;

public class ReadInput {
    public static void main(String args[]) {
        Kattio kattio = new Kattio(System.in);
        List<String> str = new ArrayList<String>();
        while(kattio.hasMoreTokens()){
            String line = kattio.getWord();
            System.out.println(line);
            if(line == null || line.length() == 0){
                break;
            }
            str.add(line);
        }
        str.forEach(System.out::println);
    }
}

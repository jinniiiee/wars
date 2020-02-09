package com.isha.prepare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class AssessMe {

    public static void main(String[] args) {
        int x = 11;
        int y = 3;
        int z = x / y;
        int h = x % y;
        System.out.println(z);
        System.out.println(h);
        String[] org = {"blue", "black","green", "red","green"};
        String sss = "blue, black, green, red, green";
        System.out.println(sss.replaceAll(" ", ""));
        System.out.println(sss);
        List<String> orgList = new ArrayList<>(Arrays.asList(org));
        String sd = "-green";
        System.out.println(sd.substring(0,1));
        System.out.println(sd.substring(1));
        System.out.println(orgList.toString());
        //orgList.stream().filter(ele -> ele.equals("green")).r
        //orgList.removeIf(ele -> ele.equals("green"));
        orgList.remove("white");
        System.out.println(orgList.toString());
        String braces = "[({})](]";
        char braceArray[] = braces.toCharArray();
        out.println(braceArray.length);
    }
}

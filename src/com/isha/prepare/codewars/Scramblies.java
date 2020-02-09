package com.isha.prepare.codewars;

import java.util.Arrays;

public class Scramblies {
    public static void main(String [] args){
        //System.out.println(scramble("rkqodlw", "world")); //==> True
        //System.out.println(scramble("cedewaraaossoqqyt", "codewars")); //==> True
        System.out.println(scramble("scriptsjava", "javascripts")); //==> False
    }
    public static boolean scramble(String str1, String str2) {
        char [] toMatch = str2.toCharArray();
        boolean foundMatch = true;
        for(int i=0; i< toMatch.length; i++){
            int index = str1.indexOf(toMatch[i]);
            if(index > -1){
                if(index == 0 && str1.length() > 1){
                    str1 = str1.substring(index+1);
                }else if(index < str1.length()-1){
                    String temp1 = str1.substring(0,index);
                    String temp2 = str1.substring(index+1);
                    str1 = temp1+temp2;
                }else{
                    str1 = str1.substring(0,index);
                }
            }else{
                foundMatch = false;
                break;
            }
        }
        return foundMatch;
    }
}

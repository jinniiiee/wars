package com.isha.prepare.codewars;

public class ZerosInFactorial {

    public static void main(String [] args){
        //System.out.println(zeros(6));
        //System.out.println(zeros(12));
        //System.out.println(zeros(100));
        //System.out.println(zeros(200));
        //System.out.println(zeros(300));
        //System.out.println(zeros(400));
        System.out.println(zeros(100));
        System.out.println(zeros(1000));
        System.out.println(zeros(10000));
        System.out.println(zeros(100000));
        System.out.println(zeros(1000000));
        System.out.println(zeros(10000000));
        System.out.println(zeros(100000000));
        System.out.println(zeros(1000000000));

        //System.out.println(zeross(53153050));
        //System.out.println(zeross(50));
        //System.out.println(zeros(102));
        long start = System.currentTimeMillis();
        //System.out.println();
        //System.out.println(zeros(915428198));
        //System.out.println(System.currentTimeMillis()-start);
        //System.out.println(zeros(100));
    }

    public static int zeross(int n) {

        return 0;
    }
    public static int zeros(int n) {
        int multipleOf10 = 0;
        for(int i=5; i<= n; i=i+5){
            if(i % 5 == 0){
                int temp10 = i;
                while(temp10 % 10 == 0){
                    //System.out.println(i);
                    temp10 = temp10/10;
                    multipleOf10++;
                    while(temp10 % 10 != 0 && temp10 % 5 == 0) {
                        //System.out.println(i);
                        temp10 = temp10 / 5;
                        multipleOf10++;
                    }
                }
                if(temp10 == i){
                    int temp5 = i;
                    while(temp5 % 5 == 0) {
                        //System.out.println(i);
                        temp5 = temp5 / 5;
                        multipleOf10++;
                    }
                }
            }
        }
        return multipleOf10;
    }

}

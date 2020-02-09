package com.isha.prepare;

public class LeftRotation {
    public static void main(String[] args){
        long[] a = {1,2,3,4,5};
        long d = 4;
        long size = a.length;
        long[] shiftArr = new long[(int) size];
        for(long i = 0l; i < d; i++){
            for(long j = 0l; j < size; j++) {
                if(j+1 < size) {
                    shiftArr[(int) j] = a[(int) (j+1)];
                }else{
                    shiftArr[(int) j] = a[0];
                }
             }
            for(long x=0; x<a.length; x++) {
                a[(int) x] = shiftArr[(int) x];
            }
        }
        System.out.print("Final array:");
        for(long x=0; x<a.length; x++) {
            System.out.print(a[(int) x]);
        }
    }
}

package com.isha.prepare;

public class CloudJump {

    public static void main(String[] args) {
        int[] c = {0, 0, 0, 0, 1, 0, 1, 0, 0, 0,1};
        int size = c.length;
        int jump = 0;
        if (size >= 2 && size <= 100 && c[size - 1] == 0) {
            for (int i = 0; i < size - 1; ) {
                if (i + 2 < size && c[i + 2] == 0) {
                    i += 2;
                } else if (c[i + 1] == 0) {
                    i += 1;
                }
                jump++;
            }
            System.out.println("Jumped steps :" + jump);
        }
    }
}

package com.isha.prepare.uc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProcessDiskMap {

    public static void main(String args[]){
        Kattio kattio = new Kattio(System.in, System.out);
        do{
            String fileLine = kattio.getWord();
            int col = fileLine.length();
            System.out.println(col);
        }while(kattio.hasMoreTokens());
    }

    public static void mains(String args[]){
        InputStream is = null;
        int i;
        char c;

        try {
            // new input stream created
            is = new FileInputStream("C:\\Users\\Admin\\Downloads\\4490d5130532efa1\\sample.in");

            System.out.println("Characters printed:");

            // reads till the end of the stream
            while((i = is.read())!=-1) {

                // converts integer to character
                c = (char)i;
                //defragmentDisk(c);
                // prints character
                System.out.print(c);
            }

        } catch(Exception e) {
            // if any I/O error occurs
            e.printStackTrace();
        } finally {
            // releases system resources associated with this stream
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

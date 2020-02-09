package com.isha.prepare.uc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FixDiskMaps {

    public static void main(String args[]) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int fillIndex = -1;
            int diskMapsEntered = 1;
            List<String> output = new ArrayList<String>();
            while (line != null) {
                int diskOccupied = 0;
                int ocOc = 0;
                if (line.length() == 0) {
                    fillIndex = -1;
                    diskOccupied = 0;
                    line = br.readLine();
                    if(line == null || line.length() == 0){
                        br.close();
                        break;
                    }
                    diskMapsEntered++;
                    continue;
                }
                if(line.length() > 80  || diskMapsEntered > 100){
                    br.close();
                    break;
                }
                char[] xRow = line.toCharArray();
                int length = xRow.length;
                ocOc = checkInputString(ocOc, xRow, length);
                fillIndex = fillIndex == -1 ? xRow.length -1 : fillIndex;
                fillIndex = defragmentDisk(fillIndex, ocOc, xRow);
                output.add(String.valueOf(xRow));
                if(fillIndex == 0){
                    output.add("");
                }
                line = br.readLine();
            }
            output.remove(output.size()-1);
            output.forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) br.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int defragmentDisk(int fillIndex, int ocOc, char[] xRow) {
        for (int i = xRow.length -1; i >= 0; i--) {
            if (i == fillIndex) {
                for(int x = 0; x < ocOc; x++) {
                    if(fillIndex -1 > -1){
                        xRow[fillIndex--] = '*';
                    }else{
                        xRow[fillIndex] = '*';
                    }
                    if(i-1 > -1) i--;
                }
            }else xRow[i] = '.';
        }
        return fillIndex;
    }

    private static int checkInputString(int ocOc, char[] xRow, int length) {
        int emptyOc = 0;
        for (int x = 0; x < length; x++) {
            if (xRow[x] == '*') {
                ocOc++;
            }
            if (xRow[x] == '.') {
                emptyOc++;
            }
        }
        if (ocOc + emptyOc != xRow.length) {
            System.out.println("Not valid input");
        }
        return ocOc;
    }
}
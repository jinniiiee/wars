package com.isha.prepare.uc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Reservation {
    public static void main(String []arg){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String[] firstInput = line.split(" ");
            if (firstInput.length > 0 && firstInput[0].chars().allMatch(Character::isDigit)
                    && firstInput[1].chars().allMatch(Character::isDigit)) {
                int n = Integer.parseInt(firstInput[0]);
                int k = Integer.parseInt(firstInput[1]);
                List<StayTime> timeEntries = new ArrayList<StayTime>();
                List<List<StayTime>> beds = prepareSpareBeds(k);
                boolean isCorrupt = false;
                while (timeEntries.size() != n) {
                    line = br.readLine();
                    if(line == null || (n >= k && k >= 1 && n < 100000)){
                        isCorrupt = true;
                        br.close();
                        break;
                    }
                    readTime(line, n, timeEntries);
                    Collections.sort(timeEntries);
                    if (line.length() == 0) {
                        isCorrupt = true;
                        br.close();
                        break;
                    }
                }
                if (isCorrupt) {
                    System.out.println(0);
                } else {
                    System.out.println(getNoOfCheckins(k, timeEntries, beds));
                }
            }
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

    private static List<List<StayTime>> prepareSpareBeds(int k) {
        List<List<StayTime>> beds = new ArrayList<List<StayTime>>(k);
        for(int i=0; i<k; i++){
            beds.add(new ArrayList<StayTime>());
        }
        return beds;
    }

    private static void readTime(String line, int n, List<StayTime> timeEntries) {
        if(!line.isEmpty()) {
            String[] time = line.split(" ");
            if (time.length > 0) {
                if (time[0].chars().allMatch(Character::isDigit) && time[1].chars().allMatch(Character::isDigit)) {
                    int inTime = Integer.parseInt(time[0]);
                    int outTime = Integer.parseInt(time[1]);
                    if (inTime >= 0 && inTime < outTime && outTime <= 1000000000) {
                        timeEntries.add(new StayTime(inTime, outTime));
                    }
                }
            }
        }
    }

    private static int getNoOfCheckins(int k, List<StayTime> timeEntries, List<List<StayTime>> beds) {
        int noOfCheckins = 0;
        for(int i=0; i<k; i++){
            List<StayTime> currentBed = beds.get(i);
            if(timeEntries != null && timeEntries.size() <= 0){
                return noOfCheckins;
            }
            StayTime firstEntry = timeEntries.get(0);
            currentBed.add(firstEntry);
            noOfCheckins++;
            timeEntries.remove(firstEntry);
            List<StayTime> removeEntries = new ArrayList<StayTime>();
            for(StayTime timeEntry : timeEntries){
                int lastOutTime = currentBed.get(currentBed.size()-1).getOutTime();
                int nextTimeIn = timeEntry.getInTime();
                if(lastOutTime <= nextTimeIn){
                    currentBed.add(timeEntry);
                    noOfCheckins++;
                    removeEntries.add(timeEntry);
                }
            }
            timeEntries.removeAll(removeEntries);
        }
        return noOfCheckins;
    }
}

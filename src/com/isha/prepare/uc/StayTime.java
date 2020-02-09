package com.isha.prepare.uc;

public class StayTime implements Comparable<StayTime>{
    private int inTime;
    private int outTime;
    StayTime(int inTime, int outTime){
        this.inTime = inTime;
        this.outTime = outTime;
    }
    public int getInTime() {
        return inTime;
    }

    public int getOutTime() {
        return outTime;
    }
    @Override
    public int compareTo(StayTime otherStayTime) {
        return this.outTime-otherStayTime.outTime;
    }
}

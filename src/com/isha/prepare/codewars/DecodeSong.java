package com.isha.prepare.codewars;

public class DecodeSong {
    public static void main(String [] args){
        System.out.println(SongDecoder("WUBWUBABCWUB"));
        System.out.println(SongDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB"));
    }
    public static String SongDecoder(String song){
        return song.replaceAll("WUB", " ").trim().replaceAll("\\s{2,}", " ");
    }
}

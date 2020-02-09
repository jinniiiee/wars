package com.isha.prepare.codewars;

public class JadeCase {
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    public static String toJadenCase(String phrase) {
        if(phrase == null || phrase.isEmpty()){
            return null;
        }
        String[] words = phrase.split(SPACE);
        String jadePhrase = EMPTY;
        for(String word : words){
            String jadeWord = word.substring(0,1).toUpperCase() + word.substring(1);
            if(words[words.length-1] == word){
                jadePhrase += jadeWord;
            }else{
                jadePhrase += jadeWord + SPACE;
            }
        }
        return jadePhrase;
    }

    public static void main(String[] args){
        String phrase = "we are not humans";
        System.out.println(toJadenCase(phrase));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase(null));
        System.out.println(toJadenCase("There has to be something we can , or u can do about it."));
    }
}

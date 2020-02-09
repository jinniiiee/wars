package com.isha.prepare.codewars;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;
public class BraceChecker {
    public enum Braces{

    }
    public static boolean isValid(String braces) {
        char braceArray[] = braces.toCharArray();
        int braceSize  = braceArray.length;
        out.println(braceSize);
        if(braceSize <= 1 || braceSize % 2 != 0){
            return false;
        }
        List openStack = new ArrayList();
        openStack.add("{");
        openStack.add("[");
        openStack.add("(");
        List closedStack = new ArrayList();
        closedStack.add("}");
        closedStack.add("]");
        closedStack.add(")");
        List openBraces = new ArrayList();
        List closeBraces = new ArrayList();
        List<Integer> closePointers = new ArrayList();
        for(int i = 0; i< braceSize; i++){
            //out.println(braceArray[i]);
            String trimValue = String.valueOf(braceArray[i]).trim();
            if(openStack.contains(String.valueOf(braceArray[i]))){
                openBraces.add(trimValue);
                closePointers.add(i);
                closeBraces.add("");
                //out.println("openn"+openBraces.toString());
            }
            if(closedStack.contains(String.valueOf(braceArray[i]))){
                out.println("before remove closed"+closeBraces.toString());
                closeBraces.remove(closePointers.get(closePointers.size()-1));
                out.println("after remove closed"+closeBraces.toString());
                closeBraces.add(closePointers.get(closePointers.size()-1), trimValue);
                closePointers.remove(closePointers.size()-1);
                out.println("next to remove"+closePointers.toString());
                out.println("closed"+closeBraces.toString());
            }
        }
        out.println(openBraces.toString());
        out.println(closeBraces.toString());
        out.println(closePointers.toString());
        return true;
    }
    public static void main(String args[]){
        out.println(BraceChecker.isValid("[({})](]"));
    }
}

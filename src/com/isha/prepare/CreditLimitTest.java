package com.isha.prepare;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CreditLimitTest {
    @Test
    public void testEmpty() {
        assertEquals(0, Transactions.findRejectedTransactions(null, 0).size());
    }

    @Test
    public void testAllPass() {
        List<String> trns = new ArrayList<String>();
        trns.add("Ram,Kumar,ram@kumar,20,T1");
        trns.add("Rajesh,Kumar,ram@kumar,20,T2");
        trns.add("Mohan,Kumar,ram@kumar,20,T3");
        trns.add("Kisan,Kumar,ram@kumar,20,T4");
        trns.add("Ram,Kumar,ram@kumar,20,T5");
        long startTime = System.nanoTime();
        assertEquals(0, Transactions.findRejectedTransactions(trns, 50).size());
        System.out.println(System.nanoTime()-startTime);
    }

    @Test
    public void testSomePass() {
        List<String> trns = new ArrayList<String>();
        trns.add("Ram,Kumar,ram@kumar,20,T1");
        trns.add("Rajesh,Kumar,ram@kumar,20,T2");
        trns.add("Mohan,Kumar,ram@kumar,20,T3");
        trns.add("Kisan,Kumar,ram@kumar,20,T4");
        trns.add("Ram,Kumar,ram@kumar,20,T5");
        long startTime = System.nanoTime();
        assertTrue(1== Transactions.findRejectedTransactions(trns, 30).size());
        System.out.println(System.nanoTime()-startTime);
    }

    @Test
    public void testMixMatchPass() {
        List<String> trns = new ArrayList<String>();
        trns.add("Ram,Kumar,ram@kumar,20,T1");
        trns.add("Rajesh,Kumar,ram@kumar,20,T2");
        trns.add("Ram,Kumar,ram@kumar,10,T9");
        trns.add("Mohan,Kumar,ram@kumar,40,T13");
        trns.add("Kisan,Kumar,ram@kumar,32,T24");
        long startTime = System.nanoTime();
        assertTrue(2== Transactions.findRejectedTransactions(trns, 30).size());
        System.out.println(System.nanoTime()-startTime);
    }
}

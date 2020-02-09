package com.isha.prepare.codewars.tests;

import com.isha.prepare.codewars.AreSame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreSameTest {
    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        //int[] a = new int[]{};
        //int[] b = new int[]{};
        assertEquals(false, AreSame.comp(a, b));
    }
}

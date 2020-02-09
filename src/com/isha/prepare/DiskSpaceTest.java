package com.isha.prepare;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class DiskSpaceTest {
	@Test
    public void test0() {
        assertFalse(DiskSpace.isWritable(0, 0, new HashSet<>()));
    }

    @Test
    public void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test
    public void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
    }

    @Test
    public void test3() {
        assertTrue(DiskSpace.isWritable(7, 3, new HashSet<>(Arrays.asList(1, 2,4))));
    }

    @Test
    public void test4() {
        assertTrue(DiskSpace.isWritable(5, 3, new HashSet<>(Arrays.asList(4,5))));
    }
}

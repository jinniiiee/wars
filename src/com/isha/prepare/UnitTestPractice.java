package com.isha.prepare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTestPractice {
    @Test
    public void shouldSayHello() {
        String name = "Isha";
        assertEquals("Hello, "+name+"!", PracticeChallenge.sayHello(name));
    }
    @Test
    public void noName() {
        assertEquals("Hello there!", PracticeChallenge.sayHello(" "));
    }
}

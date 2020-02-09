package com.isha.prepare;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmoothieTest {
    @Test
    public void classicSmoothie() {
        assertEquals("strawberry,banana,pineapple,mango,peach,honey",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,pineapple,mango,peach,honey",
                Smoothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothieWithoutTwicwStrawberry() {
        assertEquals("banana,pineapple,mango,peach,honey",
                Smoothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothieWithoutAddStrawberry() {
        try{
            assertEquals("banana,pineapple,mango,peach,honey",
                    Smoothie.ingredients("Classic,strawberry"));
            Assert.fail();
        }catch (IllegalArgumentException e){

        }

    }

    @Test
    public void classicSmoothieAddStrawberry() {
        try{
            assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                    Smoothie.ingredients("kljhl,strawberry"));
            Assert.fail();
        }catch (IllegalArgumentException e){

        }

    }
}

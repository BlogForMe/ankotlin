package com.john.commutil;

import com.android.util.NumberToCN;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToChTest {
    @Test
    public  void NumberToChTest(){
        assertEquals("一百一十五", NumberToCN.numberToCH(115));
        assertEquals("八十", NumberToCN.numberToCH(80));
        assertEquals("八十一", NumberToCN.numberToCH(81));
        assertEquals("一百零五", NumberToCN.numberToCH(105));
//        assertEquals("六十",NumberToCH.numberToCH(60));
//        assertEquals("八",NumberToCH.numberToCH(8));
//
        for(int i=0;i<10;i++){
            System.out.println(NumberToCN.numberToCH(i));
        }
        System.out.println(NumberToCN.numberToCH(115));
        System.out.println(NumberToCN.numberToCH(105));

//        System.out.println((115<<1));
    }
}

package com.jonzhou.commutil;

import com.android.util.NumberToCH;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToChTest {
    @Test
    public  void NumberToChTest(){
        assertEquals("一百一十五", NumberToCH.numberToCH(115));
        assertEquals("八十", NumberToCH.numberToCH(80));
        assertEquals("八十一", NumberToCH.numberToCH(81));
        assertEquals("一百零五", NumberToCH.numberToCH(105));
//        assertEquals("六十",NumberToCH.numberToCH(60));
//        assertEquals("八",NumberToCH.numberToCH(8));
//
        for(int i=0;i<10;i++){
            System.out.println(NumberToCH.numberToCH(i));
        }
        System.out.println(NumberToCH.numberToCH(115));
        System.out.println(NumberToCH.numberToCH(105));

//        System.out.println((115<<1));
    }
}

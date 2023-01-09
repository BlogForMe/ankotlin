package com.john.kot;

import org.junit.Test;

/**
 * ClassName:      JavaTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/12 9:46 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/10/12 9:46 AM
 * UpdateRemark:   Modify the description
 */
public class JavaTest {

    @Test
    public void arrayMap() {
        int[] mTwiceBaseCache = new int[5];
        int[] hashes = new int[6];

        for (int i = 0; i < mTwiceBaseCache.length; i++) {
            mTwiceBaseCache[i] = i + 10;
        }

        for (int i = 0; i < hashes.length; i++) {
            hashes[i] = i + 20;
        }
        Object[] array = new Object[4];
        array[0] = mTwiceBaseCache;
        array[1] = hashes;

        System.out.println(" array[0]" +  array[0]);
        System.out.println(" array[1]" +  array[1]);
        System.out.println(array);
    }
}
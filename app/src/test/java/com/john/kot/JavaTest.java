package com.john.kot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        System.out.println(" array[0]" + array[0]);
        System.out.println(" array[1]" + array[1]);
        System.out.println(array);
    }

    @Test
    public void regulartTest() {
        String[] split = "earn return".split("\\s");
        String[] split1 = "earn\treturn".split("\\s");
        String[] split2 = "earn\rreturn".split("\\s");
        String[] split3 = "earn\nreturn".split("\\s");
        System.out.println(split);
    }

    @Test
    public void groupTest() {
        Pattern compile = Pattern.compile("(?<teste>\\w+)");
        Matcher matcher = compile.matcher("The first word is a match");
        matcher.find();
        String myNamedGroup = matcher.group("teste");
        System.out.printf("This is yout named group: %s", myNamedGroup);
    }
}

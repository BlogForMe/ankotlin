package com.kot;

import android.text.TextUtils;
import org.junit.Test;

import static android.opengl.Matrix.length;
import static com.kot.RegistrationUtilTestKt.SCENE_MONEY_PACKET_CREATED;
import static com.kot.RegistrationUtilTestKt.SCENE_MONEY_PACKET_ClAIMED;

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
        //int[] mTwiceBaseCache = new int[5];
        //int[] hashes = new int[6];
        //
        //for (int i = 0; i < mTwiceBaseCache.length; i++) {
        //    mTwiceBaseCache[i] = i + 10;
        //}
        //
        //for (int i = 0; i < hashes.length; i++) {
        //    hashes[i] = i + 20;
        //}
        //Object[] array = new Object[4];
        //array[0] = mTwiceBaseCache;
        //array[1] = hashes;
        //
        //System.out.println(" array[0]" + array[0]);
        //System.out.println(" array[1]" + array[1]);
        //System.out.println(array);

        //String sceneMoneyPacketCreated = SCENE_MONEY_PACKET_CREATED;
        boolean moneyPacketClAIMED = SCENE_MONEY_PACKET_ClAIMED.equals("MONEY_PACKET_ClAIMED");
        System.out.println(moneyPacketClAIMED);

        //TextUtils.equals()

    }

    @Test
    public void regulartTest() {
        String[] split = "earn return".split("\\s");
        String[] split1 = "earn\treturn".split("\\s");
        String[] split2 = "earn\rreturn".split("\\s");
        String[] split3 = "earn\nreturn".split("\\s");
        System.out.println(split);

    }

}

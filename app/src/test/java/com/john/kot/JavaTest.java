package com.john.kot;

import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;

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

    @Test
    public void groupTest() {
        String pattern = "^(000202)(010211)(.*?)(0014A0000006150001)(?<bankId>010689003)(.*)";
        String strtext
            =
            "00020201021126470014A0000006150001010689003802150000100000105195204539953034585802MY5922FNX";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(strtext);
        matcher.find();
        String myNamedGroup = matcher.group("bankId");
        System.out.printf("This is yout named group: %s", myNamedGroup);
    }

    @Test
    public void tett() {

        String name = "2023-06-05 johndoe123";
        Pattern regex = Pattern.compile("(?<date>[0-9-]+) (?<user>\\w+)");
        Matcher matcher = regex.matcher(name);
        if (matcher.matches()) {
            MatchResult matchResult = matcher.toMatchResult();
            //Map<String, String> groups = matcher.namedGroups().keySet().stream()
            //    .collect(Collectors.toUnmodifiableMap(
            //        Function.identity(), matcher::group));
            //
            //System.out.println(groups); // {date=2023-06-05, user=johndoe123}
        }
    }

    public static void main(String[] args) {

    }

}

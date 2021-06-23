/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.android.util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import java.math.BigInteger;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ParserUtils {
    protected final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String parse(final BluetoothGattCharacteristic characteristic) {
        return parse(characteristic.getValue());
    }

    public static String parse(final BluetoothGattDescriptor descriptor) {
        return parse(descriptor.getValue());
    }

    public static String parse(final byte[] data) {
        if (data == null || data.length == 0)
            return "";

        final char[] out = new char[data.length * 3 - 1];
        for (int j = 0; j < data.length; j++) {
            int v = data[j] & 0xFF;
            out[j * 3] = HEX_ARRAY[v >>> 4];
            out[j * 3 + 1] = HEX_ARRAY[v & 0x0F];
            if (j != data.length - 1)
                out[j * 3 + 2] = '-';
        }
        return "(0x) " + new String(out);
    }

    public static String Bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }


    /**
     * 16进制str转byte
     *
     * @param str
     * @return
     */
    public static byte[] hexStrToByteArray(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++) {
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte) Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }

    public static int bin2Dec(String ts) {
        return Integer.parseInt(ts, 2);
    }

    /**
     * 16进制str转byte
     *
     * @param hexString
     * @return
     */
    public static byte[] hexString2ByteArray(String hexString) {
        if (hexString == null || "".equals(hexString)) {
            return null;
        }
        //先把字符串转换为char[]，再转换为byte[]
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] bytes = new byte[length];
        String hexDigits = "0123456789abcdef";
        for (int i = 0; i < length; i++) {
            int pos = i * 2; // 两个字符对应一个byte
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // 注1
            int l = hexDigits.indexOf(hexChars[pos + 1]); // 注2
            if (h == -1 || l == -1) { // 非16进制字符
                return null;
            }
            bytes[i] = (byte) (h | l);
        }
        return bytes;
    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }


    /**
     * byte转2进制字符串
     *
     * @param tByte
     * @return
     */
    public static String binaryByte(byte tByte) {
        return Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1);
    }

    public static short getShort(byte argB1, byte argB2) {

        return (short) ((argB1 << 8) | (argB2 & 0xFF));
    }

    /**
     * 取两个字节高几位
     *
     * @param b
     * @param length
     * @return
     */
    public static int getLeftNum(byte b, int length) {
        return b >> (8 - length);
    }


    /**
     * 取两个字节低几位bit
     *
     * @param b
     * @param length
     * @return
     */
    public static int getRightNum(byte b, int length) {
        byte mv = (byte) (0xff >> (8 - length));
        return b & mv;
    }

    /**
     * https://blog.csdn.net/bluestarjava/article/details/83446129
     *
     * @param b
     * @param startIndex 高位从0开始
     * @param endIndex
     * @return
     */
    public static int getMidNum(byte b, int startIndex, int endIndex) {
        byte i = (byte) getLeftNum(b, endIndex + 1);//先取高几位
        return getRightNum(i, endIndex - startIndex + 1);//再取低几位
    }

}

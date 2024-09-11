package com.psj.tool;

import cn.hutool.core.date.DateUtil;

import java.security.MessageDigest;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/1/4-10:02
 * @description TODO
 */

public class Md5Utils {
    public static String encode(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(text.getBytes());
            byte s[] = md.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {

        System.out.println(DateUtil.date(Long.parseLong("1716378639")*1000));
    }
}

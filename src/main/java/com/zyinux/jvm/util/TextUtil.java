package com.zyinux.jvm.util;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:33
 **/
public class TextUtil {

    public static boolean isEmpty(String s){
        if (s==null){
            return true;
        }
        return s.equals("");
    }
}

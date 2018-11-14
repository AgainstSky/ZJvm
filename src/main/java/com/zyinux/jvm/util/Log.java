package com.zyinux.jvm.util;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:21
 **/
public class Log {

    private static final int INFO=1,WARRING=2,NORMAL=3,ERROR=4;

    private static int DEBUG_MODEL=INFO;

    public static void info(String s){
        if (DEBUG_MODEL<=INFO){
            System.out.println(s);
        }
    }

    public static void warring(String s){
        if (DEBUG_MODEL<=WARRING){
            System.out.println(s);
        }
    }

    public static void normal(String s){
        if (DEBUG_MODEL<=NORMAL){
            System.out.println(s);
        }
    }

    public static void error(String s){
        if (DEBUG_MODEL <= ERROR){
            System.out.println(s);
        }
    }

}

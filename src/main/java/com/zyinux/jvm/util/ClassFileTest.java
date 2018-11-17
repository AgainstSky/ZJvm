package com.zyinux.jvm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 19:27
 **/
public class ClassFileTest {

    public static final boolean FLAG = true;
    public static final byte BYTE = 123;
    public static final char X = 'X';
    public static final short SHORT = 12345;
    public static final int INT = 123456789;
    public static final long LONG = 12345678901L;
    public static final float PI = 3.14f;
    public static final double E = 2.71828;

    private List<String> arrays=new ArrayList<>();

    public static void main(String[] args) throws RuntimeException {
        System.out.println("Hello, World!");
    }

    private void test(){

    }

    private int test2(){
        return 10;
    }
}

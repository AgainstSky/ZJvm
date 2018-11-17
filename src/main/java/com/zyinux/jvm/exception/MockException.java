package com.zyinux.jvm.exception;

import com.zyinux.jvm.util.Log;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 14:19
 **/
public class MockException {

    public static void t(Class clazz,String message){
        Log.error(clazz.getSimpleName()+" : "+message);
        System.exit(0);
    }
}

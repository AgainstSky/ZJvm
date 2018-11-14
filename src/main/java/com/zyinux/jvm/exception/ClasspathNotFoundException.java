package com.zyinux.jvm.exception;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 16:24
 **/
public class ClasspathNotFoundException extends RuntimeException {

    public ClasspathNotFoundException(String message) {
        super(message);
    }
}

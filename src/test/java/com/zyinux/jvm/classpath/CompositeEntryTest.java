package com.zyinux.jvm.classpath;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 16:13
 **/
public class CompositeEntryTest {

    @Test
    public void toStringTest() {
        CompositeEntry entry=new CompositeEntry("");
        System.out.println(entry.toString());
    }
}
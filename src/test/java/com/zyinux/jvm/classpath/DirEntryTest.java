package com.zyinux.jvm.classpath;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:56
 **/
public class DirEntryTest {

    @Test
    public void readClass() throws IOException,ClassNotFoundException {
        DirEntry entry=new DirEntry("/Users/againstsky/Desktop/code/java/Jvm/src/main/java/com/zyinux/jvm/");
        byte[] bytes = entry.readClass("Constant.java");

        for (byte b : bytes) {
            System.out.println(b);
        }

        String sepa = File.pathSeparator;
        System.out.println(sepa);
    }
}
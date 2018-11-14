package com.zyinux.jvm.classpath;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 15:28
 **/
public class ZipEntryTest {

    @Test
    public void readClass() throws IOException, ClassNotFoundException {
//        ZipEntry entry=new ZipEntry("/Users/againstsky/Downloads/test.zip");
//        entry.readClass("");
        String j = System.getProperty("java.home");
        System.out.println(j);
    }
}
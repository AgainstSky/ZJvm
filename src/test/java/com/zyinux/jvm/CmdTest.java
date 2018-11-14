package com.zyinux.jvm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:02
 **/
public class CmdTest {

    @Test
    public void parse() {
        ZYMain main=new ZYMain();
        main.main(new String[]{ "cp","/Users/againstsky/Desktop/code/java/Jvm/src/main/java/","com.zyinux.jvm.util.ClassFileTest"});
    }
}
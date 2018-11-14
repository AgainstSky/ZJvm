package com.zyinux.jvm.classpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:44
 **/
public interface Entry {

    byte[] readClass(String className);


}

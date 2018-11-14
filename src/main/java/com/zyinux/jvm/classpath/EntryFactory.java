package com.zyinux.jvm.classpath;

import java.io.File;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 16:06
 **/
public class EntryFactory {

    public static Entry createEntry(String path){
        if (path.contains(File.pathSeparator)){
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")){
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar")||path.endsWith(".JAR")
                || path.endsWith(".zip")||path.endsWith(".ZIP")){
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}

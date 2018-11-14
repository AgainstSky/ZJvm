package com.zyinux.jvm.classpath;

import com.zyinux.jvm.exception.ClasspathNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 16:12
 **/
public class WildcardEntry extends CompositeEntry implements Entry {


    public WildcardEntry(String path) {

        String baseDir=path.substring(0,path.length()-1);
        File file=new File(baseDir);
        if (!file.exists()){
            throw new ClasspathNotFoundException("dir "+baseDir+" not exists");
        }
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".jar")||f.getName().endsWith(".JAR")){
                entries.add(new ZipEntry(f.getPath()));
            }
        }
    }

}

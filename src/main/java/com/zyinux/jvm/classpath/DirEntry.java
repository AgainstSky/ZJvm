package com.zyinux.jvm.classpath;

import com.zyinux.jvm.util.Log;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:48
 **/
public class DirEntry implements Entry {

    private String absPath;

    public DirEntry(String absPath) {
        this.absPath = absPath;
    }

    public byte[] readClass(String className) {
        Source source= null;

        byte[] bytes=null;

        try {
            source = Okio.source(new File(absPath+className));
        } catch (FileNotFoundException e) {
            Log.error("class:"+absPath+className+" not found!");
            return bytes;
            //throw new ClassNotFoundException("class:"+absPath+className+" not found!");
        }

        BufferedSource buffer=Okio.buffer(source);

        try {
            bytes = buffer.readByteArray();
        } catch (IOException e) {
            return bytes;
        }

        return bytes;
    }

    @Override
    public String toString() {
        return absPath;
    }
}

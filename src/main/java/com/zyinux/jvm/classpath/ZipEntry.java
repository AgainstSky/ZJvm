package com.zyinux.jvm.classpath;

import com.zyinux.jvm.util.Log;
import okio.BufferedSource;
import okio.Okio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 15:21
 **/
public class ZipEntry implements Entry {

    private String absPath;

    public ZipEntry(String absPath) {
        this.absPath = absPath;
    }

    public byte[] readClass(String className) {
        try {
            ZipFile zipFile=new ZipFile(absPath);

            java.util.zip.ZipEntry entry = zipFile.getEntry(className);
            if (entry!=null){
                InputStream in=zipFile.getInputStream(entry);
                BufferedSource source= Okio.buffer(Okio.source(in));
                return source.readByteArray();
            }

        } catch (IOException e) {
            Log.error("zip/jar not handle absPath:"+absPath);
            return null;
        }
        return null;
    }

    @Override
    public String toString() {
        return absPath;
    }
}

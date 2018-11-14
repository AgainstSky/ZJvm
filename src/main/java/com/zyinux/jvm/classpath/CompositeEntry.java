package com.zyinux.jvm.classpath;

import com.zyinux.jvm.util.Log;
import com.zyinux.jvm.util.TextUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 15:40
 **/
public class CompositeEntry implements Entry {

    protected List<Entry> entries=new ArrayList<Entry>();

    public CompositeEntry(String pathList) {
        for (String path : pathList.split(File.pathSeparator)) {
            entries.add(EntryFactory.createEntry(path));
        }
    }

    protected CompositeEntry(){ }


    public byte[] readClass(String className) {
        for (Entry entry : entries) {
            return entry.readClass(className);
        }
        Log.error("class:"+className+" not found!");
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (Entry entry : entries) {
            sb.append(entry.toString()).append(File.pathSeparator);
        }
        String s=sb.toString();
        if (!TextUtil.isEmpty(s)){
            s=s.substring(0,s.length()-1);
        }
        return s;
    }
}

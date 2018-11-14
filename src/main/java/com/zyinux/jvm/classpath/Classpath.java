package com.zyinux.jvm.classpath;

import com.zyinux.jvm.exception.ClasspathNotFoundException;
import com.zyinux.jvm.util.TextUtil;
import lombok.Data;

import java.io.File;
import java.io.IOException;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 16:30
 **/
@Data
public class Classpath implements Entry {

    Entry bootClasspath;

    Entry extClasspath;

    Entry userClasspath;

    public Classpath(String jreOption,String cpOption) {
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    private void parseBootAndExtClasspath(String jreOption){
        String jreDir=getJreDir(jreOption);

        String jreLibPath=jreDir+File.separator+"lib"+File.separator+"*";
        bootClasspath=new WildcardEntry(jreLibPath);

        String jreExtPath=jreDir+File.separator+"lib"+File.separator+"ext"+File.separator+"*";
        extClasspath=new WildcardEntry(jreExtPath);
    }

    private String getJreDir(String jreOption) {
        if (!TextUtil.isEmpty(jreOption) && new File(jreOption).exists()){
            return jreOption;
        }
        if (new File("./jre").exists()){
            return "./jre";
        }
        String jre=System.getProperty("java.home");
        if (!TextUtil.isEmpty(jre)){
            return jre;
        }
        throw new ClasspathNotFoundException("jrePath not found jreOption:"+jreOption);
    }

    private void parseUserClasspath(String cpOption){
        if (TextUtil.isEmpty(cpOption)){
            cpOption=".";
        }
        userClasspath=EntryFactory.createEntry(cpOption);
    }

    public byte[] readClass(String className) {
        className=className+".class";
        byte[] bytes=null;
        if ((bytes=bootClasspath.readClass(className))!=null){
            return bytes;
        }
        if ((bytes=extClasspath.readClass(className))!=null){
            return bytes;
        }
        if ((bytes=userClasspath.readClass(className))!=null){
            return bytes;
        }
        return bytes;
    }

    @Override
    public String toString() {
        return userClasspath.toString();
    }
}

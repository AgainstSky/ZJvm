package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:24
 **/
public class ConstantClassInfo extends ZConstantInfo {

    private ConstantPool cp;

    short nameIndex;


    public ConstantClassInfo(ConstantPool cp) {
        this.cp = cp;
        this.tag= ConstantPoolTag.CONSTANT_Class;
    }

    @Override
    public void readInfo(ClassReader reader) {
        nameIndex=reader.readU2();
    }

    public String name(){
        return cp.getUtf8(nameIndex);
    }

}

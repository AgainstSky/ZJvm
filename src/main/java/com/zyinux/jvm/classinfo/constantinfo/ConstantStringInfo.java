package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:17
 **/
public class ConstantStringInfo extends ZConstantInfo {

    ConstantPool cp;

    short stringIndex;

    public ConstantStringInfo(ConstantPool cp) {
        this.cp = cp;
        this.tag= ConstantPoolTag.CONSTANT_String;
    }

    @Override
    public void readInfo(ClassReader reader) {
        stringIndex=reader.readU2();
    }

    @Override
    public String toString() {
        return cp.getUtf8(stringIndex);
    }
}

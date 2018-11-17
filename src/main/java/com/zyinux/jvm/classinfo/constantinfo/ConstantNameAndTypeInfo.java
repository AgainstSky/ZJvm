package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:28
 **/
public class ConstantNameAndTypeInfo extends ZConstantInfo {

    short nameIndex;

    short descIndex;

    public ConstantNameAndTypeInfo() {
        this.tag= ConstantPoolTag.CONSTANT_NameAndType;
    }

    @Override
    public void readInfo(ClassReader reader) {
        nameIndex = reader.readU2();
        descIndex = reader.readU2();
    }
}

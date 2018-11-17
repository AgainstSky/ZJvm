package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-15 15:28
 **/
public class ConstantMethodTypeInfo extends ZConstantInfo {

    private short descIndex;

    public ConstantMethodTypeInfo() {
        this.tag= ConstantPoolTag.CONSTANT_MethodType;
    }

    @Override
    public void readInfo(ClassReader reader) {
        descIndex=reader.readU2();
    }
}

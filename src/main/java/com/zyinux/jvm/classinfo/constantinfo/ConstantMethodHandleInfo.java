package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-15 15:29
 **/
public class ConstantMethodHandleInfo extends ZConstantInfo {

    private byte referenceKind;

    private short referenceIndex;

    public ConstantMethodHandleInfo() {
        this.tag= ConstantPoolTag.CONSTANT_MethodHandle;
    }

    @Override
    public void readInfo(ClassReader reader) {
        referenceKind=reader.readU1();
        referenceIndex=reader.readU2();
    }
}

package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 15:06
 **/
public class ConstantIntegerInfo extends ZConstantInfo {

    int val;

    public ConstantIntegerInfo() {
        this.tag= ConstantPoolTag.CONSTANT_Integer;
    }

    @Override
    public void readInfo(ClassReader reader) {
        val = reader.readU4();
    }
}

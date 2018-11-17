package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:01
 **/
public class ConstantDoubleInfo extends ZConstantInfo {

    double val;

    public ConstantDoubleInfo() {
        this.tag= ConstantPoolTag.CONSTANT_Double;
    }

    @Override
    public void readInfo(ClassReader reader) {
        val=Double.longBitsToDouble(reader.readU8());
    }
}

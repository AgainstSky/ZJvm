package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;
import com.zyinux.jvm.util.Math;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 15:09
 **/
public class ConstantFloatInfo extends ZConstantInfo {



    float val;

    public ConstantFloatInfo() {
        this.tag= ConstantPoolTag.CONSTANT_Float;
    }

    @Override
    public void readInfo(ClassReader reader) {
        val= Math.binaryToFloat(reader.readU4());
    }
}

package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 *
 *  CONSTANT_Long_info {
 *      u1 tag;
 *      u4 high_bytes;
 *      u4 low_bytes;
 *  }
 *
 * @create: 2018-11-14 15:51
 **/
public class ConstantLongInfo extends ZConstantInfo {

    long val;

    public ConstantLongInfo() {
        this.tag= ConstantPoolTag.CONSTANT_Long;
    }

    @Override
    public void readInfo(ClassReader reader) {
        val = reader.readU8();
    }


}

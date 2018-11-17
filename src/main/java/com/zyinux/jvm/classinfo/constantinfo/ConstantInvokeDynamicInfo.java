package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-15 15:32
 **/
public class ConstantInvokeDynamicInfo extends ZConstantInfo {

    private short bootstrapMethodAttrIndex;

    /**
     * 对常量池中NameAndTypeInfo的有效索引
     */
    private short nameAndTypeIndex;

    public ConstantInvokeDynamicInfo() {
        this.tag= ConstantPoolTag.CONSTANT_InvokeDynamic;
    }

    @Override
    public void readInfo(ClassReader reader) {
        bootstrapMethodAttrIndex=reader.readU2();
        nameAndTypeIndex=reader.readU2();
    }
}

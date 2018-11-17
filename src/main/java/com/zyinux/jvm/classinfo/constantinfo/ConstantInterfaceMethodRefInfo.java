package com.zyinux.jvm.classinfo.constantinfo;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:39
 **/
public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo {
    public ConstantInterfaceMethodRefInfo(ConstantPool cp) {
        super(cp);
        this.tag= ConstantPoolTag.CONSTANT_InterfaceMethodref;
    }
}

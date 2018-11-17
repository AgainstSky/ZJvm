package com.zyinux.jvm.classinfo.constantinfo;

import lombok.Getter;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 13:28
 **/

public class ConstantPoolTag {
    public final static byte CONSTANT_Utf8               = 1;
    public final static byte CONSTANT_Integer            = 3;
    public final static byte CONSTANT_Float              = 4;
    public final static byte CONSTANT_Long               = 5;
    public final static byte CONSTANT_Double             = 6;
    public final static byte CONSTANT_Class              = 7;
    public final static byte CONSTANT_Fieldref           = 9;
    public final static byte CONSTANT_String             = 8;
    public final static byte CONSTANT_Methodref          = 10;
    public final static byte CONSTANT_InterfaceMethodref = 11;
    public final static byte CONSTANT_NameAndType        = 12;

    public final static byte CONSTANT_MethodHandle       = 15;
    public final static byte CONSTANT_MethodType         = 16;
    public final static byte CONSTANT_InvokeDynamic      = 18;

}

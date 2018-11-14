package com.zyinux.jvm.classinfo;

import lombok.Getter;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 13:28
 **/
@Getter
public enum ConstantPoolTag {
    CONSTANT_Class((byte) 7),
    CONSTANT_FieldRef((byte) 9),
    CONSTANT_MethodRef((byte) 10),
    CONSTANT_InterfaceMethodRef((byte) 11),
    CONSTANT_String((byte) 8),
    CONSTANT_Integer((byte) 3),
    CONSTANT_Float((byte) 4),
    CONSTANT_Long((byte) 5),
    CONSTANT_Double((byte) 6),
    CONSTANT_NameAndType((byte) 12),
    CONSTANT_Utf8((byte) 1),
    CONSTANT_MethodHandle((byte) 15),
    CONSTANT_MethodType((byte) 16),
    CONSTANT_InvokeDynamic((byte) 18),;

    byte tag;

    ConstantPoolTag(byte tag) {
        this.tag = tag;
    }
}

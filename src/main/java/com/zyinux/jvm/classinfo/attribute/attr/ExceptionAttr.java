package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 变长属性，用于记录方法抛出的异常表 一个Method_info结构中最多只能有一个Exception属性表
 * @create: 2018-11-17 14:21
 **/
public class ExceptionAttr extends ZAttributeInfo {

    short[] exceptionIndexTable;

    public ExceptionAttr(String attrName, int attrLen) {
        super(attrName, attrLen);
    }

    @Override
    public void readInfo(ClassReader reader) {
        exceptionIndexTable=reader.readU2s();
    }

    public short[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}

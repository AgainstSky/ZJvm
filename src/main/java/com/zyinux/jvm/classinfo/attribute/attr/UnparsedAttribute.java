package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.AttributeInfo;
import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 17:01
 **/
public class UnparsedAttribute extends ZAttributeInfo {


    byte[] info;

    public UnparsedAttribute(String attrName, int attrLen) {
        super(attrName, attrLen);
    }


    @Override
    public void readInfo(ClassReader reader) {
        info=reader.readBytes(attrLen);
    }
}

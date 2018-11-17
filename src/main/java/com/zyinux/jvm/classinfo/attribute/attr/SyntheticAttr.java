package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.AttributeInfo;
import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 17:12
 **/
public class SyntheticAttr extends ZAttributeInfo {
    public SyntheticAttr(String attrName, int attrLen) {
        super(attrName, attrLen);
    }

    @Override
    public void readInfo(ClassReader reader) {

    }
}

package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;
import com.zyinux.jvm.util.Log;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 定长属性，指向field_info字段，用于表示常量表达式的值
 * @create: 2018-11-16 17:24
 **/
public class ConstantValueAttr extends ZAttributeInfo {

    short constantValueIndex;

    public ConstantValueAttr(String attrName, int attrLen) {
        super(attrName, 2);
        //Log.normal("ConstantValueAttr.attrLen:"+attrLen);
    }

    @Override
    public void readInfo(ClassReader reader) {
        constantValueIndex=reader.readU2();
    }
}

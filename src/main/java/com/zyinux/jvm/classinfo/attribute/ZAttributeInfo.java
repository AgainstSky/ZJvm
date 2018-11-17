package com.zyinux.jvm.classinfo.attribute;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 17:21
 **/
public abstract class ZAttributeInfo implements AttributeInfo {

    protected String attrName;

    protected int attrLen;

    public ZAttributeInfo(String attrName, int attrLen) {
        this.attrName = attrName;
        this.attrLen = attrLen;
    }
}

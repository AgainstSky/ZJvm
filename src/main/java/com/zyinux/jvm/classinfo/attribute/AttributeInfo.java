package com.zyinux.jvm.classinfo.attribute;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 16:03
 **/
public interface AttributeInfo {

    void readInfo(ClassReader reader);

}

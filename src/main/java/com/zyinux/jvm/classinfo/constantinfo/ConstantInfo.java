package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 常量池接口类
 * @create: 2018-11-14 10:40
 **/
public interface ConstantInfo {

    void readInfo(ClassReader reader);

}

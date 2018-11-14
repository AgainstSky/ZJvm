package com.zyinux.jvm.classinfo;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 常量池接口类
 * @create: 2018-11-14 10:40
 **/
public abstract class ConstantInfo {

    /**
     * 指定后面info中信息的格式
     */
    byte tag;

    byte[] info;

}

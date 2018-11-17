package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.classinfo.constantinfo.ConstantInfo;
import com.zyinux.jvm.reader.ClassReader;
import lombok.Data;
import lombok.Getter;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 15:04
 **/
@Data
public abstract class ZConstantInfo implements ConstantInfo {

    /**
     * 指定后面info中信息的格式
     */
    byte tag;

}

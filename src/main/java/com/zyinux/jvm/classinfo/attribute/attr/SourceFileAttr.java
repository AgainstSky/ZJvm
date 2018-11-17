package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.AttributeInfo;
import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.classinfo.constantinfo.ConstantPool;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 可选定长属性，只会出现在ClassFile结构中用于指出源文件名
 * @create: 2018-11-16 17:13
 **/
public class SourceFileAttr extends ZAttributeInfo {

    ConstantPool cp;

    /**
     * 指向常量池中UTF8结构
     */
    short sourceFileIndex;

    public SourceFileAttr(String name,int len,ConstantPool cp) {
        super(name,len);
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        sourceFileIndex=reader.readU2();
    }

    public String getFileName(){
        return cp.getUtf8(sourceFileIndex);
    }
}

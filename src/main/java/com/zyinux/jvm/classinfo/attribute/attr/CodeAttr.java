package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.AttributeInfoFactory;
import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.classinfo.constantinfo.ConstantPool;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: Code是变长属性，位于Method_info结构体中，
 * 包含了某个方法，类实力初始化方法，接口初始化方法的Java虚拟机指令和相关信息
 * 如果是native或者abstract方法，那么Method_info不能有这个属性。此外只能有一个Code属性
 * @create: 2018-11-17 14:03
 **/
public class CodeAttr extends ZAttributeInfo {

    public static class ExceptionTableEntry {
        short startPc;
        short endPc;
        short handlerPc;
        short catchType;

        public ExceptionTableEntry(ClassReader reader) {
            startPc=reader.readU2();
            endPc=reader.readU2();
            handlerPc=reader.readU2();
            catchType=reader.readU2();
        }

        public static ExceptionTableEntry[] readExceptionTable(ClassReader reader){
            short N = reader.readU2();
            ExceptionTableEntry[] entries=new ExceptionTableEntry[N];

            for (int i = 0; i < entries.length; i++) {
                entries[i]=new ExceptionTableEntry(reader);
            }

            return entries;
        }
    }

    ConstantPool cp;

    short maxStack;

    short maxLocals;


    byte[] code;

    ExceptionTableEntry[] exceptionTable;

    ZAttributeInfo[] attributes;


    public CodeAttr(String attrName, int attrLen,ConstantPool cp) {
        super(attrName, attrLen);
        this.cp=cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        maxStack = reader.readU2();
        maxLocals = reader.readU2();

        int N = reader.readU4();
        code=reader.readBytes(N);

        exceptionTable=ExceptionTableEntry.readExceptionTable(reader);
        attributes= AttributeInfoFactory.readAttributes(reader,cp);

    }
}

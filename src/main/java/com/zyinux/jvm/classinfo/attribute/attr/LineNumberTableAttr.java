package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 用于存储调试信息
 * @create: 2018-11-17 14:28
 **/
public class LineNumberTableAttr extends ZAttributeInfo {

    public static class LineNumberTableEntry {
        short startPc;
        short lineNumber;

        public LineNumberTableEntry(ClassReader reader) {
            startPc = reader.readU2();
            lineNumber = reader.readU2();
        }

    }

    LineNumberTableEntry[] lineNumberTable;

    public LineNumberTableAttr(String attrName, int attrLen) {
        super(attrName, attrLen);
    }

    @Override
    public void readInfo(ClassReader reader) {
        short N = reader.readU2();
        lineNumberTable = new LineNumberTableEntry[N];
        for (int i = 0; i < lineNumberTable.length; i++) {
            lineNumberTable[i] = new LineNumberTableEntry(reader);
        }
    }
}

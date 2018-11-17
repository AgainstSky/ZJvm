package com.zyinux.jvm.classinfo.attribute.attr;

import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-17 14:40
 **/
public class LocalVariableTableAttr extends ZAttributeInfo {

    public static class LocalVariableTableEntry {
        short startPc;
        short length;
        short nameIndex;
        short descIndex;
        short index;

        public LocalVariableTableEntry(ClassReader reader) {
            startPc = reader.readU2();
            length = reader.readU2();
            nameIndex = reader.readU2();
            descIndex = reader.readU2();
            index = reader.readU2();
        }
    }

    LocalVariableTableEntry[] localVariableTable;

    public LocalVariableTableAttr(String attrName, int attrLen) {
        super(attrName, attrLen);
    }

    @Override
    public void readInfo(ClassReader reader) {
        localVariableTable=new LocalVariableTableEntry[reader.readU2()];
        for (int i = 0; i < localVariableTable.length; i++) {
            localVariableTable[i]=new LocalVariableTableEntry(reader);
        }
    }
}

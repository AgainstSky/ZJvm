package com.zyinux.jvm.classinfo.attribute;

import com.zyinux.jvm.classinfo.attribute.attr.*;
import com.zyinux.jvm.classinfo.constantinfo.ConstantPool;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 16:33
 **/
public class AttributeInfoFactory {


    public static ZAttributeInfo[] readAttributes(ClassReader reader, ConstantPool cp) {

        short N = reader.readU2();
        ZAttributeInfo[] infos = new ZAttributeInfo[N];
        for (int i = 0; i < infos.length; i++) {
            infos[i] = readAttribute(reader, cp);
        }

        return infos;
    }

    private static ZAttributeInfo readAttribute(ClassReader reader, ConstantPool cp) {
        short nameIndex = reader.readU2();
        String attrName = cp.getUtf8(nameIndex);
        int attrLen = reader.readU4();
        ZAttributeInfo info = create(attrName, attrLen, cp);
        info.readInfo(reader);
        return info;
    }

    private static ZAttributeInfo create(String attrName, int attrLen, ConstantPool cp) {
        ZAttributeInfo info = null;
        switch (attrName) {
            case AttributeTag.CODE:
                info = new CodeAttr(attrName, attrLen, cp);
                break;
            case AttributeTag.ConstVal:
                info = new ConstantValueAttr(attrName, attrLen);
                break;
            case AttributeTag.Deprecated:
                info = new DeprecatedAttr(attrName, attrLen);
                break;
            case AttributeTag.Exceptions:
                info = new ExceptionAttr(attrName, attrLen);
                break;
            case AttributeTag.LineNumberTable:
                info = new LineNumberTableAttr(attrName, attrLen);
                break;
            case AttributeTag.LocalVariableTable:
                info = new LocalVariableTableAttr(attrName, attrLen);
                break;
            case AttributeTag.SourceFile:
                info = new SourceFileAttr(attrName, attrLen, cp);
                break;
            case AttributeTag.Synthetic:
                info = new SyntheticAttr(attrName, attrLen);
                break;
            default:
                info = new UnparsedAttribute(attrName, attrLen);
                break;
        }
        return info;
    }
}

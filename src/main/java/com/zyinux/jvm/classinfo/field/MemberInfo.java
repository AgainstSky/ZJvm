package com.zyinux.jvm.classinfo.field;

import com.zyinux.jvm.classinfo.attribute.AttributeInfo;
import com.zyinux.jvm.classinfo.attribute.AttributeInfoFactory;
import com.zyinux.jvm.classinfo.constantinfo.ConstantPool;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-16 16:24
 **/
public class MemberInfo {

    private ConstantPool cp;

    private short accessFlags;

    private short nameIndex;

    private short descIndex;

    private AttributeInfo[] attributes;

    private int memberCount;

    public MemberInfo(ClassReader reader, ConstantPool cp) {
        this.cp = cp;
        accessFlags = reader.readU2();
        nameIndex = reader.readU2();
        descIndex = reader.readU2();
        attributes= AttributeInfoFactory.readAttributes(reader,cp);
    }

    public static MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool) {
        short N = reader.readU2();
        MemberInfo[] memberInfos = new MemberInfo[N];

        for (int i = 0; i < memberInfos.length; i++) {
            memberInfos[i] = new MemberInfo(reader, constantPool);
        }

        return memberInfos;
    }

    public String getName(){
        return cp.getUtf8(nameIndex);
    }

    public String getDesc(){
        return cp.getUtf8(descIndex);
    }
}

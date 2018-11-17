package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:35
 **/
public class ConstantMemberRefInfo extends ZConstantInfo {

    protected ConstantPool cp;

    protected short classIndex;

    protected short nameAndTypeIndex;

    public ConstantMemberRefInfo(ConstantPool cp) {
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {

        classIndex=reader.readU2();
        nameAndTypeIndex=reader.readU2();
    }

    public String className(){
        return cp.getClassName(classIndex);
    }

    public String[] nameAndType() {
        return cp.getNameAndType(nameAndTypeIndex);
    }
}

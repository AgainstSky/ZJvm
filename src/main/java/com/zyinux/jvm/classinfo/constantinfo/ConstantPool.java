package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.exception.MockException;
import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:17
 **/
public class ConstantPool {

    private ZConstantInfo[] constants;

    private int constantCount;

    public ConstantPool(ClassReader reader) {

        int count = reader.readU2();
        constantCount=count;
        //TODO:这里的constants的长度也许可以优化？
        constants = new ZConstantInfo[count];

        /**
         * 索引从 1 开始，常量池中常量个数至少比count少一个
         * 另外ConstantLongInfo和ConstantDoubleInfo会占用两个位置
         */
        for (int i = 1; i < count; i++) {
            constants[i]=readConstantInfo(reader,this);
            if (constants[i].tag == ConstantPoolTag.CONSTANT_Long ||
                    constants[i].tag == ConstantPoolTag.CONSTANT_Double) {
                i++;
            }
        }
    }

    private ZConstantInfo readConstantInfo(ClassReader reader,ConstantPool cp){
        byte tag = reader.readU1();
        ZConstantInfo c=ConstantInfoFactory.create(tag,cp);
        if (c!=null){
            // c always not null!
            c.readInfo(reader);
        }
        return c;
    }

    public String getUtf8(short index){
        return ((ConstantUtf8Info)getConstantInfo(index)).val;
    }

    public String getClassName(short classIndex) {
        return getUtf8(((ConstantClassInfo)getConstantInfo(classIndex)).nameIndex);
    }

    public String[] getNameAndType(short nameAndTypeIndex) {

        //checkIndex(nameAndTypeIndex);

        ConstantNameAndTypeInfo cp= (ConstantNameAndTypeInfo) getConstantInfo(nameAndTypeIndex);
        String[] r=new String[2];
        r[0]=getUtf8(cp.nameIndex);
        r[1]=getUtf8(cp.descIndex);

        return r;
    }

    public ZConstantInfo getConstantInfo(short index){

        checkIndex(index);

        ZConstantInfo cp=constants[index];
        if (cp!=null){
            return cp;
        }

        MockException.t(getClass(),"index:"+index+" size:"+constants.length);
        return null;
    }

    private void checkIndex(short index){
        if (index < 1 || index >= constants.length) {
            MockException.t(getClass(),"index:"+index+" size:"+constants.length);
        }
    }

    public int getConstantCount(){
        return constantCount;
    }
}

package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.exception.MockException;

import static com.zyinux.jvm.classinfo.constantinfo.ConstantPoolTag.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:56
 **/
public class ConstantInfoFactory {


    public static ZConstantInfo create(byte tag,ConstantPool cp){
//        System.out.println();
//        System.out.printf("tag: %04x + tag:%d",tag,tag);
//        System.out.println();
        switch (tag){
            case CONSTANT_Float:
                return new ConstantFloatInfo();
            case CONSTANT_Class:
                return new ConstantClassInfo(cp);
            case CONSTANT_Double:
                return new ConstantDoubleInfo();
            case CONSTANT_Integer:
                return new ConstantIntegerInfo();
            case CONSTANT_Fieldref:
                return new ConstantFieldRefInfo(cp);
            case CONSTANT_Long:
                return new ConstantLongInfo();
            case CONSTANT_String:
                return new ConstantStringInfo(cp);
            case CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo();
            case CONSTANT_Utf8:
                return new ConstantUtf8Info();
            case CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodRefInfo(cp);
            case CONSTANT_Methodref:
                return new ConstantMethodRefInfo(cp);
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandleInfo();
            case CONSTANT_MethodType:
                return new ConstantMethodTypeInfo();
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamicInfo();
        }

        MockException.t(ConstantInfoFactory.class,"error constant type! tag:"+tag);

        return null;
    }
}

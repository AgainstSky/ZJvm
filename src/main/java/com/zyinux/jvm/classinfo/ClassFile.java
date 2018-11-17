package com.zyinux.jvm.classinfo;

import com.zyinux.jvm.classinfo.attribute.AttributeInfoFactory;
import com.zyinux.jvm.classinfo.attribute.ZAttributeInfo;
import com.zyinux.jvm.classinfo.constantinfo.ConstantInfo;
import com.zyinux.jvm.classinfo.constantinfo.ConstantPool;
import com.zyinux.jvm.classinfo.field.MemberInfo;
import com.zyinux.jvm.exception.MockException;
import com.zyinux.jvm.reader.ClassReader;
import com.zyinux.jvm.util.Log;
import lombok.Data;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 10:00
 **/
@Data
public class ClassFile {

    public static final int MAGIC = 0xCAFEBABE;

    /**
     * 魔数
     */
    private int magic;

    /**
     * 副版本号
     */
    private short minorVersion;

    /**
     * 主版本号 jdk1.x,x>=2  ==>  44+x
     */
    private short majorVersion;

    /**
     * 常量池计数器  值至少为常量池中常量数量 + 1
     */
    private int constantPoolCount;

    /**
     * 常量池
     */
    private ConstantPool constantPool;

    /**
     * 访问标志  表示该类或者接口的访问权限及属性
     * ACC_PUBLIC       0x0001    public类型所有类型
     * ACC_FINAL        0x0010    final类型类 不允许有子类
     * ACC_SUPER        0x0020    使用invokespecial指令时需要对父类方法做特殊处理
     * ACC_INTERFACE    0x0200    接口类型接口
     * ACC_ABSTRACT     0x0400    抽象类型类
     * ACC_SYNTHETIC    0x1000	  表示该class并非由java文件生成
     * ACC_ANNOTATION   0x2000	  注解类型
     * ACC_ENUM         0x4000	  枚举类型
     */
    private short accessFlags;

    private short thisClass;

    private short superClass;

    private int interfaceCount;

    private short[] interfaces;

    private MemberInfo[] fields;

    private MemberInfo[] methods;

    private ZAttributeInfo[] attributes;


    private ClassFile() {

    }

    public static ClassFile parse(byte[] data) {
        ClassFile classFile = new ClassFile();
        classFile.read(new ClassReader(data));
        return classFile;
    }

    private void read(ClassReader reader) {

        /**
         * 读取和检查魔数
         */
        readAndCheckMagic(reader);

        /**
         * 读取并检查版本
         */
        readAndCheckVersion(reader);

        /**
         * 读取常量池
         */
        readConstantPool(reader);

        accessFlags = reader.readU2();

        thisClass = reader.readU2();

        superClass = reader.readU2();

//        interfaceCount = reader.readU2();
//
        interfaces = reader.readU2s();

        interfaceCount = interfaces.length;

        fields = MemberInfo.readMembers(reader, constantPool);

        methods = MemberInfo.readMembers(reader, constantPool);

        attributes = AttributeInfoFactory.readAttributes(reader, constantPool);

    }

    private void readConstantPool(ClassReader reader) {
        constantPool = new ConstantPool(reader);
        constantPoolCount = constantPool.getConstantCount();
    }

    private void readAndCheckVersion(ClassReader reader) {
        minorVersion = reader.readU2();
        majorVersion = reader.readU2();
        switch (majorVersion) {
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (minorVersion == 0) {
                    return;
                }
        }
        MockException.t(getClass(), "This Class Version not support");
    }

    private void readAndCheckMagic(ClassReader reader) {
        magic = reader.readU4();
        if (magic != MAGIC) {
            MockException.t(getClass(), "magic error!");
        }
        Log.info("magic ok!");
    }

    public String className() {
        return constantPool.getClassName(thisClass);
    }

    public String superClassName() {
        if (superClass > 0) {
            return constantPool.getClassName(superClass);
        }
        return "";
    }

    public String[] interfaceNames() {
        String[] names = new String[interfaceCount];
        for (int i = 0; i < names.length; i++) {
            names[i] = constantPool.getClassName(interfaces[i]);
        }
        return names;
    }
}

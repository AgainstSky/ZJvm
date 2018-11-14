package com.zyinux.jvm.classinfo;

import com.zyinux.jvm.reader.ClassReader;
import lombok.Data;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 10:00
 **/
@Data
public class ClassFile {

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
     * 常量池计数器  值为常量池中常量数量 + 1
     */
    private short constantPoolCount;

    /**
     * 常量池
     */
    private ConstantInfo[] constantPool;

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

//    private short interfaceCount;

    private short[] interfaces;


    private ClassFile() {

    }

    public static ClassFile parse(byte[] data){
        ClassFile classFile=new ClassFile();
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

        interfaces = reader.readU2s();



    }

    private void readConstantPool(ClassReader reader) {
        //TODO:
    }

    private void readAndCheckVersion(ClassReader reader) {

    }

    private void readAndCheckMagic(ClassReader reader) {

    }

    public String ClassName() {
        //TODO:
        return "";
    }
}

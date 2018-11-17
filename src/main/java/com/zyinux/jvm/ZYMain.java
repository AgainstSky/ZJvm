package com.zyinux.jvm;

import com.zyinux.jvm.classinfo.ClassFile;
import com.zyinux.jvm.classinfo.field.MemberInfo;
import com.zyinux.jvm.classpath.Classpath;
import com.zyinux.jvm.command.Cmd;
import com.zyinux.jvm.exception.MockException;
import com.zyinux.jvm.reader.ClassReader;
import com.zyinux.jvm.util.Log;
import com.zyinux.jvm.util.TextUtil;
import sun.tools.java.ClassPath;

import java.util.Arrays;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 14:16
 **/

public class ZYMain {

    public void main(String[] args){
        Cmd parse = Cmd.parse(args);
        Log.normal(parse.toString());
        if (parse.isVersionFlag()){
            Log.normal(Constant.version);
        }else if (parse.isHelpFlag()|| TextUtil.isEmpty(parse.getClass_())){
            //TODO:Help And EmptyClass handle
        }else {
            startJVM(parse);
        }
    }

    private void startJVM(Cmd cmd) {
        Classpath classpath=new Classpath(cmd.getXJreOption(),cmd.getCpOption());
        String className=cmd.getClass_().replace(".","/");


        ClassFile classFile=loadClass(className,classpath);
        System.out.println("magic" + classFile.getMagic());
        System.out.println("version: "+ classFile.getMajorVersion()+"."+classFile.getMinorVersion());
        System.out.println("className:"+ classFile.className()+ "  superClassName:"+classFile.superClassName());
        System.out.println("interfaceName"+ Arrays.toString(classFile.interfaceNames()));

        System.out.println("\n fields:");
        for (MemberInfo memberInfo : classFile.getFields()) {
            System.out.println(memberInfo.getName()+" desc: "+memberInfo.getDesc());
        }

        System.out.println("\n methods:");
        for (MemberInfo memberInfo : classFile.getMethods()) {
            System.out.println(memberInfo.getName()+" desc: "+memberInfo.getDesc());
        }

    }

    private ClassFile loadClass(String className, Classpath classpath){
        byte[] bytes = classpath.readClass(className);
        if (bytes!=null){
            return ClassFile.parse(bytes);
        }

        MockException.t(getClass(),"解析类文件错误");
        return null;
    }


}

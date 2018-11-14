package com.zyinux.jvm;

import com.zyinux.jvm.classpath.Classpath;
import com.zyinux.jvm.command.Cmd;
import com.zyinux.jvm.reader.ClassReader;
import com.zyinux.jvm.util.Log;
import com.zyinux.jvm.util.TextUtil;

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

        byte[] bytes = classpath.readClass(className);

        //Log.info("classpath: userpath="+classpath+" jrePath="+classpath.getBootClasspath().toString());

        if (bytes!=null){
            ClassReader reader=new ClassReader(bytes);
//            reader.readU1();
//            short c = reader.readU2();
            reader.readU4();
            System.out.println("classData:[ ");
            for (int i = 0; i < reader.data.length; i++) {
                System.out.printf("%02x ",reader.data[i]);
            }
            System.out.println(" ]");
        }
    }


}

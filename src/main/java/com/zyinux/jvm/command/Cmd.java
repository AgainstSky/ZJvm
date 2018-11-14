package com.zyinux.jvm.command;

import com.zyinux.jvm.Constant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 13:37
 **/
@Data
public class Cmd {

    private boolean helpFlag;

    private boolean versionFlag;

    private String xJreOption;

    private String cpOption;

    private String class_;

    private List<String> args;

    public static Cmd parse(String[] argv){
        Cmd cmd=new Cmd();
        cmd.args=new ArrayList<String>();

        for (int i = 0; i < argv.length; i++) {
            if (argv[i].equalsIgnoreCase(Constant.HELP_CMD)){
                cmd.helpFlag=true;

            }else if (argv[i].equalsIgnoreCase(Constant.VERSION_CMD)){
                cmd.versionFlag=true;

            }else if (argv[i].equalsIgnoreCase(Constant.XJRE_CMD)) {
                if (i<argv.length-1){
                    cmd.xJreOption=argv[++i];
                }

            }else if (argv[i].equalsIgnoreCase(Constant.CLASSPATH_CMD)){
                if (i<argv.length-1)
                    cmd.cpOption=argv[++i];

            }else {
                cmd.args.add(argv[i]);
            }
        }
        if (cmd.args.size()>0){
            cmd.class_=cmd.args.get(0);
            cmd.args.remove(0);
        }

        return cmd;
    }

//    @Override
//    public String toString(){
//        return "Cmd: { helpFlag = "
//                +helpFlag
//                +", versionFlag = "
//                +versionFlag
//                +", cpOption = "
//                +cpOption
//                +""
//    }
}

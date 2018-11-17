package com.zyinux.jvm.classinfo.constantinfo;

import com.zyinux.jvm.reader.ClassReader;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 16:08
 **/
public class ConstantUtf8Info extends ZConstantInfo {

    String val;

    public ConstantUtf8Info() {
        this.tag= ConstantPoolTag.CONSTANT_Utf8;
    }

    @Override
    public void readInfo(ClassReader reader) {
        short length = reader.readU2();

        byte[] bytes = reader.readBytes(length);

        val=new String(bytes);

//        DataInputStream dis = new DataInputStream(new ByteInputStream(bytes, bytes.length));
//
//        try {
//            val = dis.readUTF();
//        } catch (IOException e) {
//            e.printStackTrace();
//            //Log.error(e.getMessage());
//            val = "";
//        }

    }
}

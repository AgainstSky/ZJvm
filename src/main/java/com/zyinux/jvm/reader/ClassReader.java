package com.zyinux.jvm.reader;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.zyinux.jvm.exception.MockException;
import com.zyinux.jvm.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-13 19:49
 **/
public class ClassReader {

    public byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;

        printData();
    }

    private void printData(){
//        System.out.println("\n classData:[ ");
//        for (int i = 0; i < data.length; i++) {
//            System.out.printf("%02x ",data[i]);
//
//        }
//        System.out.println(" ] ");
    }

    public byte readU1(){
        byte r = data[0];
        data= Arrays.copyOfRange(data,1,data.length);
        printData();
        return r;
    }

    public short readU2(){
//        i+=data[0];

//        System.out.printf("i: %04x \n",i);
//        System.out.printf("data1: %04x \n",data[1]);
//        System.out.printf("b: %04x \n",b);

        int a = (data[0] << 8 | ( data[1] & 0xFF) ) & 0xFFFF;
        data =Arrays.copyOfRange(data,2,data.length);
        printData();
        return (short) a;
    }

    public int readU4(){

        int r=(data[0] << 24) | (data[1] << 16 & 0xFFFFFF ) | (data[2] << 8 & 0xFFFF) | (data[3] & 0xFF);
        //Java Class magic 0xCAFEBABE 可以使用这个方法来读取
        data =Arrays.copyOfRange(data,4,data.length);
        printData();
        return r;
    }

    //读取Unit16表 表的大小由开头的unit16数据指定
    public short[] readU2s(){
        short n=readU2();
        short[] r=new short[n];
        for (short i = 0; i < n; i++) {
            r[i]=readU2();
        }
        printData();
        return r;
    }

    public byte[] readBytes(short n){
        byte[] r=new byte[n];
        for (short i = 0; i < n; i++) {
            r[i]=readU1();
        }
        printData();
        return r;
    }

    public byte[] readBytes(int n){
        byte[] r=new byte[n];
        for (short i = 0; i < n; i++) {
            r[i]=readU1();
        }
        printData();
        return r;
    }

    public long readU8(){
        DataInputStream dis=new DataInputStream(new ByteInputStream(data,data.length));
        try {
            long l = dis.readLong();
            data=Arrays.copyOfRange(data,8,data.length);
            return l;
        } catch (IOException e) {
            Log.error(e.getLocalizedMessage());
            return 0l;
        }
//        long d0=data[0];
//        long d1=data[1];
//        long d2=data[2];
//        long d3=data[3];
//        long d4=data[4];
//        long d5=data[5];
//        long d6=data[6];
//        long d7=data[7];
//        long r =
//                (d0 << 56) |
//                        (d1<<48 & 0xFFFFFFFFFF)
//
//        return d7;
    }
}

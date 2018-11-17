package com.zyinux.jvm.util;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-14 15:18
 **/
public class Math {

    public static final int POSITIVE_INFINITY=0x7F800000;

    public static final int NEGATIVE_INFINITY=0xFF800000;

    public static final int NAN_MAX_L=0x7FFFFFFF;

    public static final int NAN_MIN_L=0x7F800001;

    public static final int NAN_MAX_H=0xFFFFFFFF;

    public static final int NAN_MIN_H=0xFF800001;

    public static float binaryToFloat(int o){
        return Float.intBitsToFloat(o);

////        if (o==POSITIVE_INFINITY){
////            return Float.POSITIVE_INFINITY;
////        }else if (o==NEGATIVE_INFINITY){
////            return Float.NEGATIVE_INFINITY;
////        } else if (
////                o <= NAN_MAX_H && o >= NAN_MIN_H || o >= NAN_MAX_L
////                ) {
////            return Float.NaN;
////        }
////        int s = ((o >> 31) == 0) ? 1 : -1;
////        int e = ((o >> 23) & 0xFF);
////        int m = (e == 0) ?
////                (o & 0x7FFFFF) << 1 :
////                (o & 0x7FFFFF) | 0x800000;
////        return  (s * m * (float)java.lang.Math.pow(2, e - 150));
    }
}

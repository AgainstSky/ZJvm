package com.zyinux.jvm.runtime.datearea;

import com.zyinux.jvm.exception.MockException;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 局部变量表
 * @create: 2018-11-23 14:04
 **/
public class LocalVars {

    private Slot[] slots;

    private int maxLocals;

    public LocalVars(int maxLocals) {
        if (maxLocals > 0) {
            this.maxLocals = maxLocals;
            slots = new Slot[maxLocals];
        } else {
            slots = null;
            maxLocals = 0;
        }

    }

    public void setInt(int index, int val) {
        checkIndex(index);

        slots[index] = new Slot();

        slots[index].setNum(val);
    }

    public int getInt(int index) {
        checkIndex(index);

        return slots[index].getNum();
    }


    public void setFloat(int index, float val) {
        checkIndex(index);

        slots[index] = new Slot();

        int bits = Float.floatToIntBits(val);
        slots[index].setNum(bits);
    }

    public float getFloat(int index) {
        checkIndex(index);
        int bits = slots[index].getNum();

        return Float.intBitsToFloat(bits);
    }

    public void setLong(int index, long val) {
        checkIndex(index + 1);


        slots[index] = new Slot();

        slots[index+1] = new Slot();

        slots[index].setNum((int) val);
        slots[index + 1].setNum((int) (val >> 32));
    }

    public long getLong(int index) {
        checkIndex(index + 1);

        long low = slots[index].getNum();
        long high = slots[index + 1].getNum();
        return high << 32 | low;
    }

    public void setDouble(int index,double val){
        setFloat(index,Double.doubleToLongBits(val));
    }

    public double getDouble(int index){
        return Double.longBitsToDouble(getLong(index));
    }

    public void setRef(int index,Object object){
        checkIndex(index);
        slots[index]=new Slot();

        slots[index].setRef(object);
    }

    public Object getRef(int index){
        checkIndex(index);
        return slots[index].getRef();
    }

    private void checkIndex(int index) {
        if (index >= maxLocals) {
            MockException.t(getClass(), "局部变量表越界");
        }
    }
}

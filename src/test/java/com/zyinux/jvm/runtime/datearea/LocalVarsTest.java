package com.zyinux.jvm.runtime.datearea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: Jvm
 * @author: zYinux
 * @content:
 * @create: 2018-11-23 14:18
 **/
public class LocalVarsTest {

    @Test
    public void getLong() {
        long val = 21L;
        LocalVars localVars = new LocalVars(1024);
        localVars.setLong(0,val);
        assert val==localVars.getLong(0);
        System.out.println(localVars.getLong(0));
    }

    @Test
    public void getFloat(){
        float val=3.141592656f;
        LocalVars localVars=new LocalVars(10);
        localVars.setFloat(0,val);
        assert val==localVars.getFloat(0);
        System.out.println(localVars.getFloat(0));
    }
}
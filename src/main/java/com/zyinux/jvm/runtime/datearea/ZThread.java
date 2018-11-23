package com.zyinux.jvm.runtime.datearea;

import com.zyinux.jvm.Profiles;

/**
 * @program: Jvm
 * @author: zYinux
 * @content: 线程模型
 * @create: 2018-11-23 13:40
 **/
public class ZThread {

    /**
     * program count 程序计数器
     */
    int pc;

    /**
     * 线程私有栈 数据区
     */
    ZStack<Frame> stack;


    public ZThread() {
        stack=new ZStack<>(Profiles.stackFrameSize);
    }

    public void pushFrame(Frame frame){
        stack.push(frame);
    }

    public Frame popFrame() {
        return stack.pop();
    }

    public Frame currentFrame(){
        return stack.peek();
    }
}

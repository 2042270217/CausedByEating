package org.example.utils;

public class ThreadLocalUtils {
    private static final ThreadLocal THREAD_LOCAL=new ThreadLocal();

    //根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    //存储值
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}

package com.itheima.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        //.class : 获取类字节码；.getClassLoader ： 获取前面得到的字节码的类加载器；
        // .getResourceAsStream ：根据类加载器来读取配置
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}

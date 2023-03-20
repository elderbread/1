package com.zyb.test;

import java.io.File;

public class test1 {
    public static void main(String[] args) {
        File file = new File("E:\\zyb");
        System.out.println(file.exists());
        File file2 = new File("E:\\zyb\\test\\test1");
        System.out.println(file2.exists());
        file2.mkdirs();
    }
    
}

package com.hongxp.redis;

import com.hongxp.redis.impl.DefaultableFactoryImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) {
        Defaultable factory = DefaultableFactory.create(DefaultableImpl::new);

    }

    public static void readFileByLines() throws Exception {
        //项目的绝对路径，也就是想修改的文件路径
        String filePath = "D:\\develop\\workspace\\test\\src\\main\\java\\com";
        File f = new File(filePath);
        String content = "/*\n" +
                "* @(#)" + f.getName() + "\n" +
                "*\n" +
                "* Copyright ***版权信息***.\n" +
                "*/\n";
        fileTree(f, content);
    }

    /**
     * 取出所有的文件及文件夹
     *
     * @param f 文件夹对象
     * @throws Exception
     */
    public static void fileTree(File f, String content) throws Exception {
        File[] t = f.listFiles();
        for (int i = 0; i < t.length; i++) {
            if (t[i].isDirectory()) {
                fileTree(t[i], content);
            } else {
                insert(t[i], content);
            }
        }
    }
           
        /*public static void main(String[] args) { 
            try { 
                readFileByLines(); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
        }*/

    /**
     * 开始插入内容
     *
     * @param f 文件对象
     * @throws IOException
     */
    public static void insert(File f, String content) throws IOException {
        File temp = File.createTempFile("temp", null);
        temp.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        FileOutputStream tempOut = new FileOutputStream(temp);
        FileInputStream tempInput = new FileInputStream(temp);
        raf.seek(0);
        byte[] buf = new byte[64];
        int hasRead = 0;
        while ((hasRead = raf.read(buf)) > 0) {
            tempOut.write(buf, 0, hasRead);
        }
        raf.seek(0);

        raf.write(content.getBytes());
        while ((hasRead = tempInput.read(buf)) > 0) {
            raf.write(buf, 0, hasRead);
        }
        raf.close();
        tempOut.close();
        tempInput.close();
    }
}
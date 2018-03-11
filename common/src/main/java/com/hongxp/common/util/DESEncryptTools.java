package com.hongxp.common.util;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Xianping.Hong
 * @Date : 2018/3/11 16:04
 */
public class DESEncryptTools {
    //加密算是是des
    private static final String ALGORITHM = "DES";
    //转换格式
    private static final String TRANSFORMATION = "DES/ECB/PKCS5Padding";

    /**
     * 利用8个字节64位的key给src加密
     *
     * @param src
     * @param key
     * @return
     */
    public static byte[] encrypt(byte[] src, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = keyFactory.generateSecret(keySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new SecureRandom());
            byte[] enMsg = cipher.doFinal(src);
            return enMsg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 利用8个字节64位的key给src解密
     *
     * @param enBytes
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] enBytes, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            KeySpec keySpec = new DESKeySpec(key);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new SecureRandom());
            return cipher.doFinal(enBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String key = "520hongxp";

    public static void main(String[] args) throws Exception {
        String msg = "hello world. hello ucom";
        System.out.println("加密前：" + msg);
        byte[] encryptBytes = DESEncryptTools.encrypt(msg.getBytes(), key.getBytes());
        System.out.println("加密后：" + new String(encryptBytes));
        byte[] deMsgBytes = DESEncryptTools.decrypt(encryptBytes, key.getBytes());
        System.out.println("解密后：" + new String(deMsgBytes));
    }
}

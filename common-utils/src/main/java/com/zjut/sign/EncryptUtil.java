package com.zjut.sign;

import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class EncryptUtil {

    /**
     * 密钥是16位长度的byte[]进行Base64转换后得到的字符串
     */
    private static final String ENCRYPT_KEY = "LmMGStGtOpF4xNyvYt54EQ==";
    private static final int HASHLEN = 16;

    private static final byte[] KEY = new byte[8];
    private static final byte[] IV = new byte[8];
    private static final SecretKeySpec SECRET_KEY_SPEC;
    private static final IvParameterSpec IV_PARAM;

    static {
        getKeyIv(ENCRYPT_KEY, KEY, IV);
        SECRET_KEY_SPEC = new SecretKeySpec(KEY, "DES");
        IV_PARAM = new IvParameterSpec(IV);
    }

    private static void getKeyIv(String encryptKey, byte[] key, byte[] iv) {
        byte[] buffer = Base64Utils.decodeFromString(encryptKey);
        System.arraycopy(buffer, 0, key, 0, key.length);
        System.arraycopy(buffer, 8, iv, 0, iv.length);
    }

    /**
     * 经过封装的DES/CBC加密算法。
     */
    private static byte[] encryptDesCbc(byte[] buffer) throws Exception {
        Cipher encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
        encrypt.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC, IV_PARAM);
        return encrypt.doFinal(buffer, 0, buffer.length);
    }

    /**
     * 经过封装的DES/CBC解密算法。
     */
    private static byte[] decryptDesCbc(byte[] buffer) throws Exception {
        Cipher decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
        decrypt.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC, IV_PARAM);
        return decrypt.doFinal(buffer, 0, buffer.length);
    }

    private static byte[] md5Hash(byte[] buf, int offset, int length)
            throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(buf, offset, length);
        return md.digest();
    }

    private static byte[] appendBytes(byte[] bytesA, byte[] bytesB) {
        ByteBuffer bb = ByteBuffer.allocate(bytesA.length + bytesB.length);
        bb.put(bytesA).put(bytesB);
        return bb.array();
    }

    /**
     * 对字符串进行加密
     */
    public static String encrypt(String string) throws Exception {
        if (string == null || string.equals("")) {
            return string;
        }

        byte[] encrypt = string.getBytes("utf-8");
        byte[] md5Hash = md5Hash(encrypt, 0, encrypt.length);
        byte[] totalByte = appendBytes(md5Hash, encrypt);
        byte[] temp = encryptDesCbc(totalByte);
        /*
        Modify By Jianhui Lu
        调整Base64加密，保持和业务系统一致（便于日后JDK升级，调整前升级解密会失败）
         */
        return new BASE64Encoder().encode(temp);
//        return Base64Utils.encodeToString(temp);
    }

    /**
     * 对字符串进行解密
     */
    public static String decrypt(String string) throws Exception {
        if (string == null || string.equals("")) {
            return string;
        }
        /*
        Modify By Jianhui Lu
        调整Base64解密，保持和业务系统一致（便于日后JDK升级，调整前升级解密会失败）
         */
        byte[] encBuf = new BASE64Decoder().decodeBuffer(string.replaceAll(" ", "+"));
//        byte[] encBuf = Base64Utils.decodeFromString(string.replaceAll(" ", "+"));
        byte[] temp = decryptDesCbc(encBuf);
        byte[] md5Hash = md5Hash(temp, HASHLEN, temp.length - HASHLEN);

        for (int i = 0; i < HASHLEN; i++) {
            if (md5Hash[i] != temp[i]) {
                throw new Exception("MD5校验错误。");
            }
        }

        return new String(temp, HASHLEN, temp.length - HASHLEN, "utf-8");
    }
}

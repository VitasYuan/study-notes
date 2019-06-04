package com.zjut.sign;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yuanweipeng
 */
public class MD5Digest {


    private static final String CHARSET_NAME = "UTF-8";
    private MessageDigest md5;
    private String content;
    private Charset charset = Charset.forName(CHARSET_NAME);

    private MD5Digest(String content) {
        try {
            this.setMd5(MessageDigest.getInstance("MD5"));
            this.setContent(content);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private byte[] getDigest() {
        return this.getMd5().digest(getContent().getBytes(this.getCharset()));
    }


    private MessageDigest getMd5() {
        return this.md5;
    }


    private void setMd5(MessageDigest md5) {
        this.md5 = md5;
    }

    private static MD5Digest getInstance(String content, String... charsetName) {
        MD5Digest md5 = new MD5Digest(content);
        if (charsetName.length > 0) {
            md5.setCharset(Charset.forName(charsetName[0]));
        }
        return md5;
    }

    /**
     * @return content
     */
    private String getContent() {
        return this.content;
    }

    /**
     * @param content 要设置的 content
     */
    private void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        byte[] digest = this.getDigest();
        StringBuffer buf = new StringBuffer();
        for (byte temp : digest) {
            buf.append(toFullHex(temp));
        }
        return buf.toString();
    }

    private String toFullHex(byte data) {
        int val = ((int) data) & 0xff;

        if (val < 16) {
            return "0" + Integer.toHexString(val);
        } else {
            return Integer.toHexString(val);
        }
    }

    @Override
    public boolean equals(Object o) {
        return toString().equals(o);
    }

    /**
     * @return charset
     */
    private Charset getCharset() {
        return this.charset;
    }

    /**
     * @param charset 要设置的 charset
     */
    private void setCharset(Charset charset) {
        this.charset = charset;
    }

    public static String getMD5Digest(String origin) {
        return getInstance(origin).toString();
    }
}

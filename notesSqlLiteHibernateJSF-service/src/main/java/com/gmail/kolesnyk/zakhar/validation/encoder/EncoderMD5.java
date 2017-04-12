package com.gmail.kolesnyk.zakhar.validation.encoder;


import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncoderMD5 implements Encoder {
    private MessageDigest md5;

    public EncoderMD5() {
        try {
            md5 = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encodePassword(String password) {
        if (password == null || password.equals("") || password.length() > 20) {
            throw new IllegalArgumentException("wrong password");
        }
        return (new HexBinaryAdapter()).marshal(md5.digest(password.getBytes()));
    }
}

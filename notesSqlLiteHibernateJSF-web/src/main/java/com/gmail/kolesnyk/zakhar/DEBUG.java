package com.gmail.kolesnyk.zakhar;


import com.gmail.kolesnyk.zakhar.validation.encoder.EncoderMD5;

public class DEBUG {
    public static void main(String[] args) {
        System.out.println(new EncoderMD5().encodePassword("111"));
    }
}

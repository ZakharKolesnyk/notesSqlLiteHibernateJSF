package com.gmail.kolesnyk.zakhar.validation.encoder;

/**
 * The {@code Encoder} used to encoding password
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
public interface Encoder {

    /**
     * method allow to encode password
     *
     * @param password password what need to encode
     * @return encoded password
     */
    String encodePassword(String password);
}

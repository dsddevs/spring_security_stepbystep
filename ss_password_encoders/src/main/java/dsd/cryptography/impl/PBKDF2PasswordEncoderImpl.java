package dsd.cryptography.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class PBKDF2PasswordEncoderImpl implements PasswordEncoder {

    private final Pbkdf2PasswordEncoder pbkdf2Encoder;

    public PBKDF2PasswordEncoderImpl(){
        var hmac512 = Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512;
        this.pbkdf2Encoder = new Pbkdf2PasswordEncoder("secretKey", 16, 310000, hmac512);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return pbkdf2Encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return pbkdf2Encoder.matches(rawPassword, encodedPassword);
    }

}

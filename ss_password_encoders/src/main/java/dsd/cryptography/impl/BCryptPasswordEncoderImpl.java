package dsd.cryptography.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

public class BCryptPasswordEncoderImpl implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptEncoder;
    private static final byte[] SALT = generatedNumbers();

    public BCryptPasswordEncoderImpl(){
        this.bCryptEncoder = new BCryptPasswordEncoder(12, new SecureRandom(SALT)); // STRENGTH 12 = 2^12 = 4096 iterations
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return bCryptEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return bCryptEncoder.matches(rawPassword, encodedPassword);
    }

    private static byte[] generatedNumbers(){
        byte[] numbers = new byte[16];
        new SecureRandom().nextBytes(numbers);
        return numbers;
    }
}

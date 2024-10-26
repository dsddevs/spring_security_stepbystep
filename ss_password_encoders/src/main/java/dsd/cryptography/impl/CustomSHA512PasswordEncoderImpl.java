package dsd.cryptography.impl;

import dsd.cryptography.PasswordEncoderTypes;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomSHA512PasswordEncoderImpl implements PasswordEncoder, PasswordEncoderTypes {

    @Override
    public String encode(CharSequence rawPassword) {
        return encodeByCustomSHA512(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        var customSHA512 = encodeByCustomSHA512(rawPassword.toString());
        return encodedPassword.equals(customSHA512);
    }
}

package dsd.cryptography.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class SCryptPasswordEncoderImpl implements PasswordEncoder {

    private final SCryptPasswordEncoder sCryptEncoder;

    public SCryptPasswordEncoderImpl(){
        this.sCryptEncoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return sCryptEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return sCryptEncoder.matches(rawPassword, encodedPassword);
    }
}

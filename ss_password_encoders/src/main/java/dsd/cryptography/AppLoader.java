package dsd.cryptography;

import dsd.cryptography.impl.BCryptPasswordEncoderImpl;
import dsd.cryptography.impl.PBKDF2PasswordEncoderImpl;
import dsd.cryptography.impl.SCryptPasswordEncoderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppLoader {
    public static void main(String[] args) {

        PasswordEncoder pbkdf2Encoder = new PBKDF2PasswordEncoderImpl();
        PasswordEncoder bCryptEncoder = new BCryptPasswordEncoderImpl();
        PasswordEncoder sCryptEncoder = new SCryptPasswordEncoderImpl();

        String password = "dsd123";

        String pbkdf2Password = pbkdf2Encoder.encode(password);
        String bCryptPassword = bCryptEncoder.encode(password);
        String sCryptPassword = sCryptEncoder.encode(password);

        System.out.println("PBKDF2: " + pbkdf2Password);
        System.out.println("BCrypt: " + bCryptPassword);
        System.out.println("SCrypt: " + sCryptPassword);

    }
}

package dsd.cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface PasswordEncoderTypes {
    default String encodeByCustomSHA512(String password){
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md512 = MessageDigest.getInstance("SHA-512");
            byte[] digested = md512.digest(password.getBytes());
            for (byte b : digested) sb.append(0xFF & b);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("ERROR: Bad algorithm: " + e.getMessage());
        }
        return sb.toString();
    }
}

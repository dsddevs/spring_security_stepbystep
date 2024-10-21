package dsd.security.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final String AUTH_USERNAME = "sara";
    private static final String AUTH_PASSWORD = "test123";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        var userCredentialsAuth = authenticateUserCredentials(username, password);
        if (AUTH_USERNAME.equals(username) && AUTH_PASSWORD.equals(password)) {
            return userCredentialsAuth;
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken
                .class
                .isAssignableFrom(authentication);
    }

    private UsernamePasswordAuthenticationToken authenticateUserCredentials(String username, String password){
        return new UsernamePasswordAuthenticationToken(username, password, List.of());
    }
}

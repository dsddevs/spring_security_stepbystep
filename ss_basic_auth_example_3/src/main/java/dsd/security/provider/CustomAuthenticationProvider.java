package dsd.security.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final String MY_USERNAME = "dsd";
    private static final String MY_PASSWORD = "test123";
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        var userCredentialsAuth = authenticateUserCredentials(username, password);
        if (MY_USERNAME.equals(username) && MY_PASSWORD.equals(password)){
            return userCredentialsAuth;
        } else {
            throw new AuthenticationCredentialsNotFoundException("ERROR: User credentials not authenticated");
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

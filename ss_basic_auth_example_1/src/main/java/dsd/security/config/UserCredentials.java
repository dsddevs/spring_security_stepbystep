package dsd.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserCredentials {

    @Bean
    public UserDetailsService userDetailsService(){
        var userCredentials = User
                .builder()
                .username("dsd")
                .password("password123")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(userCredentials);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

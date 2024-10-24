package dsd.security.config;

import dsd.security.utils.ISqlQueries;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig implements ISqlQueries {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        String userByUsernameQuery = getUserByUsername();
        String authorityByUsernameQuery = getAuthorityByUsername();
        userDetailsManager.setUsersByUsernameQuery(userByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authorityByUsernameQuery);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

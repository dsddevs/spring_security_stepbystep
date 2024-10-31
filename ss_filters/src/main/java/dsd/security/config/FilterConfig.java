package dsd.security.config;

import dsd.security.filter.AuthenticationLoggingFilter;
import dsd.security.filter.RequestValidationFilter;
import dsd.security.filter.StaticKeyAuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@AllArgsConstructor
@Configuration
public class FilterConfig {

    private final StaticKeyAuthFilter customStaticKeyAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        var customRequestValidationFilter = new RequestValidationFilter();
        var customAuthLoggingFilter = new AuthenticationLoggingFilter();
        var authenticationFilter = BasicAuthenticationFilter.class;
        http
                .addFilterBefore(customRequestValidationFilter, authenticationFilter)
                .addFilterAfter(customAuthLoggingFilter, authenticationFilter)
                .addFilterAt(customStaticKeyAuthFilter, authenticationFilter)
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

}

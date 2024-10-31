package dsd.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StaticKeyAuthFilter implements Filter {

    @Value("${auth.static.key}")
    private String staticKey;

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String authenticationKey = httpRequest.getHeader("Authorization");
        if (staticKey.equals(authenticationKey)) filterChain.doFilter(httpRequest, httpResponse);
        else httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}

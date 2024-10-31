package dsd.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String requestId = request.getHeader("Request-Id");
        logger.info("SUCCESS: Request authenticated by id: " + requestId);
        filterChain.doFilter(request, response);

    }
}

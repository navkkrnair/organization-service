package com.cts.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class UserContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String correlationId = httpServletRequest.getHeader(UserContext.CORRELATION_ID);
        log.debug("Adding {} to header through RestTemplate with value: {}", UserContext.CORRELATION_ID, correlationId);
        UserContextHolder.getContext()
                         .setCorrelationId(correlationId);

        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}

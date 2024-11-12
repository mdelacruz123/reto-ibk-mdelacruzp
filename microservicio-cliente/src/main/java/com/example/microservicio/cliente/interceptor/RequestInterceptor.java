package com.example.microservicio.cliente.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final String TRACKING_ID_HEADER = "tracking-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String trackingId = request.getHeader(TRACKING_ID_HEADER);

        if (trackingId != null) {
            MDC.put("trackingId", trackingId);
        } else {
            MDC.put("trackingId", "UNAVAILABLE");
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.clear();
    }
}
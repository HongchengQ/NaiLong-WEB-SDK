//package com.nailong.websdk.interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import tools.jackson.databind.ObjectMapper;
//
//@Component
//@RequiredArgsConstructor
//public class AuthInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader == null) {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            response.getWriter().write("{\"code\":401,\"message\":\"Missing Authorization\"}");
//            return false;
//        }
//
//        try {
//            // 解析并验证
//            AuthHeader auth = parseAuthHeader(authHeader);
//            if (!verifyAuth(auth)) {
//                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                response.getWriter().write("{\"code\":401,\"message\":\"Invalid Authorization\"}");
//                return false;
//            }
//
//            // 将解析后的对象放入request attribute
//            request.setAttribute("authInfo", auth);
//            return true;
//
//        } catch (Exception e) {
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            response.getWriter().write("{\"code\":400,\"message\":\"Invalid Authorization format\"}");
//            return false;
//        }
//    }
//
//    private AuthHeader parseAuthHeader(String authJson) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(authJson, AuthHeader.class);
//    }
//
//    private boolean verifyAuth(AuthHeader auth) {
//        // 实现验证逻辑
//        return true;
//    }
//}
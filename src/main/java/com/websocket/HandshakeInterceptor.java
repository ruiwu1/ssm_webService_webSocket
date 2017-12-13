package com.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;

import java.util.Map;

/**
 * 握手拦截器
 *  拦截握手前，握手后的两个切面
 */
public class HandshakeInterceptor implements org.springframework.web.socket.server.HandshakeInterceptor {

    /**
     * Interceptor before hander
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
package com.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * -配置WebSocket访问的地址
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    // webSocket
    private static final String WEBSOCKET_SERVER ="/websocket";
    // 不支持webSocket的话用sockjs
    private static final String SOCKJS ="/sockjs/websocket";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        /**
         * 支持websocket 的 connection
         */
        registry.addHandler(new WebSocketHander(),WEBSOCKET_SERVER).addInterceptors(new HandshakeInterceptor());

        /**
         * 不支持websocket的connenction,采用sockjs
         */
        registry.addHandler(new WebSocketHander(),SOCKJS).addInterceptors(new HandshakeInterceptor()).withSockJS();
    }
}

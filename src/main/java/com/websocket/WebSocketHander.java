package com.websocket;

import org.slf4j.Logger;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * WebSocket处理器
 *
 */
public class WebSocketHander implements WebSocketHandler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WebSocketHander.class);

    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();

    /**
     * after connection establish
     *  握手实现连接后
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("connect success...");
        users.add(session);
    }

    /**
     * process the received message
     * 发送信息前的处理
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        sendMessageToUsers(new TextMessage(webSocketMessage.getPayload() + "hello"));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        logger.info("connenction error,close the connection...");
        users.remove(webSocketSession);
    }

    /**
     * 在此刷新页面就相当于断开WebSocket连接,原本在静态变量userSocketSessionMap中的
     * WebSocketSession会变成关闭状态(close)，但是刷新后的第二次连接服务器创建的
     * 新WebSocketSession(open状态)又不会加入到userSocketSessionMap中,所以这样就无法发送消息
     * 因此应当在关闭连接这个切面增加去除userSocketSessionMap中当前处于close状态的WebSocketSession，
     * 让新创建的WebSocketSession(open状态)可以加入到userSocketSessionMap中
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.info("close the connenction..."+closeStatus.toString());
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}

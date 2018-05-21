package com.darvasroland.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author darvasr
 */
@ServerEndpoint("/echo")
public class EchoWebSocket {


    private Session session;

    private Logger logger = Logger.getLogger(EchoWebSocket.class.getName());

    @OnOpen
    public void connect(Session session) {
        this.session = session;
        logger.log(Level.INFO, "Echo Session: " + session);
    }

    @OnClose
    public void close() {
        this.session = null;
        logger.log(Level.INFO, "Echo Session closed!");
    }

    @OnMessage
    public void onMessage(String msg) {
        logger.log(Level.INFO, "Message: "+msg);
        this.session.getAsyncRemote().sendText("Echo: "+msg);
    }
}

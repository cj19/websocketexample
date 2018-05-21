package com.darvasroland.websocket;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;

import javax.faces.application.FacesMessage;

/**
 * @author darvasr
 */
@PushEndpoint("/notify")
public class NotificationResource {

    @OnMessage
    public FacesMessage onMessage(FacesMessage message) {
        return message;
    }
}

package com.darvasroland.websocket;

import com.darvasroland.model.Notification;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author darvasr
 */
@ApplicationScoped
@Named("notificationBean")
public class NotificationBean {

    private Notification notification;

    private List<Notification> notifications = new ArrayList<>();


    @PostConstruct
    private void init() {
        notifications.add(new Notification(1L, "Hello world!", "darvasr"));
    }

    public void addToList() {
        this.notifications.add(notification);
        notificationPush();
    }

    private void notificationPush() {
        String summary = "New notification!";
        String detail = "Added to the list!";
        String channel = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(channel, new FacesMessage(summary, detail));
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}

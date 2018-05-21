package com.darvasroland.model;

/**
 * @author darvasr
 */
public class Notification {

    private Long id;

    private String message;

    private String author;

    public Notification() {
    }

    public Notification(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

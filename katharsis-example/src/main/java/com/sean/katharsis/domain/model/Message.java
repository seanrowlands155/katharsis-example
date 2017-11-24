package com.sean.katharsis.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

/**
 * Created by sean on 23/11/17.
 */

@JsonApiResource(type = "messages")
public class Message {

    private String title;

    private String messageContent;

    @JsonBackReference
    @JsonApiRelation(opposite = "message")
    private Greeting parent;

    @JsonApiId
    private long id;

    public Message() {

    }

    public Message(String title, String messageContent) {
        this.title = title;
        this.messageContent = messageContent;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Message setMessageContent(String messageContent) {
        this.messageContent = messageContent;
        return this;
    }

    public Greeting getParent() {
        return parent;
    }

    public Message setParent(Greeting parent) {
        this.parent = parent;
        return this;
    }

    public long getId() {
        return id;
    }

    public Message setId(long id) {
        this.id = id;
        return this;
    }
}

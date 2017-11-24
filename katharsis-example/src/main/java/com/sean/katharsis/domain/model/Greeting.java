package com.sean.katharsis.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

import java.util.List;

@JsonApiResource(type = "greetings")
public class Greeting {

  @JsonApiId
  private long id;

  private String content;

  @JsonApiRelation(opposite = "parent")
  @JsonManagedReference
  private List<Message> message;

  public Greeting()
  {

  }

  public Greeting(long id, String content, List<Message> message) {
    this.id = id;
    this.content = content;
    this.message = message;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Message> getMessage() {
    return message;
  }

  public Greeting setMessage(List<Message> message) {
    this.message = message;
    return this;
  }
}

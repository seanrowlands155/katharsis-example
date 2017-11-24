package com.sean.katharsis.domain.repository.persistence;

import com.sean.katharsis.domain.model.Message;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sean on 23/11/17.
 */
@Component
public class MessagesRepo implements BaseRepo<Message> {

    List<Message> messages = new ArrayList<>();
    private static AtomicLong CURRENT_ID = new AtomicLong(0);

    @Override
    public Message save(Message objToSave) {
       this.messages.add(objToSave);
       return objToSave;
    }

    @Override
    public Message create(Message objToCreate) {
        objToCreate.setId(CURRENT_ID.incrementAndGet());
        this.messages.add(objToCreate);
        return objToCreate;
    }

    @Override
    public Message delete(Long objToDelete) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return this.messages;
    }


}

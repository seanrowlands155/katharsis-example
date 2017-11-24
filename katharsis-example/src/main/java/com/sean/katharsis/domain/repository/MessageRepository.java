package com.sean.katharsis.domain.repository;

import com.sean.katharsis.domain.model.Message;
import com.sean.katharsis.domain.repository.persistence.MessagesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class MessageRepository extends ResourceRepositoryBase<Message, Long> {

    @Autowired
    MessagesRepo messagesRepo;

    public MessageRepository() {
        super(Message.class);
    }

    @Override
    public synchronized ResourceList<Message> findAll(QuerySpec querySpec) {
        return querySpec.apply(this.messagesRepo.findAll());
    }

    @Override
    public <S extends Message> S save(S resource) {
        System.out.println("Message save");
        this.messagesRepo.save(resource);
        return resource;
    }

    @Override
    public <S extends Message> S create(S resource) {
        if (resource.getId() != 0)
        {
            throw new IllegalArgumentException("Not Allowed An Idea");
        }
        System.out.println("Message create");
        this.messagesRepo.create(resource);
        return resource;
    }

}

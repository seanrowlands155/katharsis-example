package com.codenotfound.katharsis.domain.repository;

import com.codenotfound.katharsis.domain.model.Greeting;
import com.codenotfound.katharsis.domain.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryBase;
import io.katharsis.resource.list.ResourceList;

/**
 * Created by sean on 23/11/17.
 */
@Component
public class MessageGreetingRelationshipRepository extends RelationshipRepositoryBase<Message, Long, Greeting, Long> {

    @Autowired
    private MessageRepository messageRepository;

    protected MessageGreetingRelationshipRepository() {
        super(Message.class, Greeting.class);
    }

    @Override
    public ResourceList<Greeting> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {

        return super.findManyTargets(sourceId, fieldName, querySpec);
    }
}

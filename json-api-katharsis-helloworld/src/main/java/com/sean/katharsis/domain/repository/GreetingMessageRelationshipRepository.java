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
public class GreetingMessageRelationshipRepository extends RelationshipRepositoryBase<Greeting, Long, Message, Long> {

    @Autowired
    private MessageRepository messageRepository;

    protected GreetingMessageRelationshipRepository() {
        super(Greeting.class, Message.class);
    }

    @Override
    public ResourceList<Message> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {

        return super.findManyTargets(sourceId, fieldName, querySpec);
    }

    @Override
    public void addRelations(Greeting source, Iterable<Long> targetIds, String fieldName) {
        super.addRelations(source, targetIds, fieldName);
        targetIds.forEach(messageID -> messageRepository.findOne(messageID, new QuerySpec(Message.class)).setParent(source));
    }
}

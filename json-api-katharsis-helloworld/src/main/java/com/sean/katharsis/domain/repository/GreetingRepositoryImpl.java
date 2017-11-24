package com.codenotfound.katharsis.domain.repository;

import com.codenotfound.katharsis.domain.model.Greeting;
import com.codenotfound.katharsis.domain.repository.persistence.GreetingsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

import java.util.HashMap;
import java.util.Map;

@Component
public class GreetingRepositoryImpl extends ResourceRepositoryBase<Greeting, Long> {

    private Map<Long, Greeting> greetings = new HashMap<>();

    @Autowired
    GreetingsRepo greetingsRepo;

    public GreetingRepositoryImpl() {
        super(Greeting.class);
    }

    @Override
    public synchronized ResourceList<Greeting> findAll(QuerySpec querySpec) {
        return querySpec.apply(this.greetingsRepo.findAll());
    }

    @Override
    public <S extends Greeting> S save(S resource) {

        System.out.println("Greeting Save");
        this.greetingsRepo.save(resource);
        return resource;
    }

    @Override
    public <S extends Greeting> S create(S resource) {
        if (resource.getId() != 0)
        {
            throw new IllegalArgumentException("Not Allowed An Idea");
        }
        System.out.println("Greeting Create");
        this.greetingsRepo.create(resource);
        return resource;
    }
}

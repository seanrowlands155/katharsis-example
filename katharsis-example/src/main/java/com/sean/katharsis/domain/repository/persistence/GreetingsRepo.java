package com.sean.katharsis.domain.repository.persistence;

import com.sean.katharsis.domain.model.Greeting;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by sean on 23/11/17.
 */
@Component
public class GreetingsRepo implements BaseRepo<Greeting> {
    List<Greeting> greetings = new ArrayList<>();

    private static AtomicLong CURRENT_ID = new AtomicLong(0);

    @Override
    public Greeting save(final Greeting greeting) {
        Greeting existing = greetings.stream().filter(g -> g.getId() == greeting.getId()).collect(Collectors.toList()).get(0);
        BeanUtils.copyProperties(greeting,existing);
        return existing;
    }

    @Override
    public Greeting create(final Greeting greeting) {
        greeting.setId(CURRENT_ID.incrementAndGet());
        this.greetings.add(greeting);
        return greeting;
    }

    @Override
    public Greeting delete(final Long id) {
        return null;
    }

    @Override
    public List<Greeting> findAll() {
        return this.greetings;
    }
}

package com.nitish.mapper;

import com.nitish.domain.Greeting;
import com.nitish.domain.MorphiaGreetingDomain;
import org.springframework.stereotype.Component;

@Component
public class MorphiaDomainMapper implements GreetingMapper<Greeting, MorphiaGreetingDomain> {
    @Override
    public MorphiaGreetingDomain createMorphia(Greeting greeting) {
        MorphiaGreetingDomain morphiaGreetingDomain = new MorphiaGreetingDomain();
        morphiaGreetingDomain.setId(greeting.getId());
        morphiaGreetingDomain.setName(greeting.getName());
        morphiaGreetingDomain.setMessage(greeting.getMessage());
        return morphiaGreetingDomain;
    }

    @Override
    public Greeting createGreeting(MorphiaGreetingDomain morphiaGreetingDomain) {
        Greeting greeting = new Greeting();
        greeting.setId(morphiaGreetingDomain.getId());
        greeting.setName(morphiaGreetingDomain.getName());
        greeting.setMessage(morphiaGreetingDomain.getMessage());
        return greeting;
    }
}

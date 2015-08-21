package com.nitish.service;

import com.nitish.domain.Greeting;

import java.util.Collection;

public interface GreetingServiceInterface {
    Collection<Greeting> createGreeting(Collection<Greeting> greetings);

    Collection<Greeting> getAllGreeting();

    Greeting getGreetingFor(String greetingId);

    void deleteGreetingFor(String greetingId);

    Greeting updateGreetingIntoDb(Greeting greeting);

    boolean isGreetingExistFor(String greetingId);
}

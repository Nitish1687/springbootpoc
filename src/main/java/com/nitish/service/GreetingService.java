package com.nitish.service;

import com.nitish.domain.Greeting;
import com.nitish.repository.GreetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GreetingService implements GreetingServiceInterface {
    @Autowired
    private GreetingDao greetingDao;

    @Override
    public Collection<Greeting> createGreeting(Collection<Greeting> greetings) {
        return greetingDao.save(greetings);
    }

    @Override
    public Collection<Greeting> getAllGreeting() {
        return greetingDao.findAll();
    }

    @Override
    public Greeting getGreetingFor(String greetingId) {
        return greetingDao.findOne(greetingId);
    }

    @Override
    public void deleteGreetingFor(String greetingId) {
        greetingDao.delete(greetingId);
    }

    @Override
    public Greeting updateGreetingIntoDb(Greeting greeting) {
        return greetingDao.save(greeting);
    }

    @Override
    public boolean isGreetingExistFor(String greetingId) {
        return greetingDao.exists(greetingId);
    }
}

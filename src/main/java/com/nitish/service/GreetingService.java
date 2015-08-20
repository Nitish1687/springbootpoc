package com.nitish.service;

import com.nitish.domain.Greeting;
import com.nitish.repository.GreetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GreetingService {
    @Autowired
    private GreetingDao greetingDao;
    public Collection<Greeting> createGreeting(Collection<Greeting> greetings) {
        return greetingDao.save(greetings);
    }

    public Collection<Greeting> getAllGreeting() {
        return greetingDao.findAll();
    }

    public Greeting getGreetingFor(String greetingId) {
        return greetingDao.findOne(greetingId);
    }

    public void deleteGreetingFor(String greetingId) {
        greetingDao.delete(greetingId);
    }

    public Greeting updateGreetingIntoDb(Greeting greeting) {
        return greetingDao.save(greeting);
    }

    public boolean isGreetingExistFor(String greetingId) {
        return greetingDao.exists(greetingId);
    }
}

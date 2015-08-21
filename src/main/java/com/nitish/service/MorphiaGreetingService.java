package com.nitish.service;

import com.nitish.domain.Greeting;
import com.nitish.domain.MorphiaGreetingDomain;
import com.nitish.mapper.MorphiaDomainMapper;
import com.nitish.repository.MorphiaGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MorphiaGreetingService implements GreetingServiceInterface {

    @Autowired
    private MorphiaDomainMapper morphiaDomainMapper;
    @Autowired
    private MorphiaGreetingRepository morphiaGreetingRepository;

    @Override
    public Collection<Greeting> createGreeting(Collection<Greeting> greetings) {
        Collection<MorphiaGreetingDomain> morphiaGreetingDomainList = new ArrayList<>();
        for (Greeting greeting : greetings) {
            morphiaGreetingDomainList.add(morphiaDomainMapper.createMorphia(greeting));
        }
        morphiaGreetingRepository.addGreetings(morphiaGreetingDomainList);
        return greetings;
    }

    @Override
    public Collection<Greeting> getAllGreeting() {
        List<MorphiaGreetingDomain> morphiaGreetingDomainList = morphiaGreetingRepository.retrieveAllGreeting();
        Collection<Greeting> greetings = new ArrayList<>();
        for (MorphiaGreetingDomain morphiaGreetingDomain : morphiaGreetingDomainList) {
            greetings.add(morphiaDomainMapper.createGreeting(morphiaGreetingDomain));
        }
        return greetings;
    }

    @Override
    public Greeting getGreetingFor(String greetingId) {
        MorphiaGreetingDomain morphiaGreetingDomain = morphiaGreetingRepository.retrieveGreetingFor(greetingId);
        return morphiaDomainMapper.createGreeting(morphiaGreetingDomain);
    }

    @Override
    public void deleteGreetingFor(String greetingId) {
        morphiaGreetingRepository.deleteGreetingFor(greetingId);
    }

    @Override
    public Greeting updateGreetingIntoDb(Greeting greeting) {
        morphiaGreetingRepository.update(morphiaDomainMapper.createMorphia(greeting));
        return greeting;
    }

    @Override
    public boolean isGreetingExistFor(String greetingId) {
        return morphiaGreetingRepository.isGreetingExist(greetingId);
    }
}

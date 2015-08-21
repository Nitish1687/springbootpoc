package com.nitish.repository;

import com.mongodb.WriteResult;
import com.nitish.domain.MorphiaGreetingDomain;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class MorphiaGreetingRepository {

    @Autowired
    private Datastore datastore;

    public void addGreetings(Collection<MorphiaGreetingDomain> morphiaGreetingDomainList) {
        datastore.save(morphiaGreetingDomainList);
    }

    public List<MorphiaGreetingDomain> retrieveAllGreeting() {
        return datastore.createQuery(MorphiaGreetingDomain.class).asList();
    }

    public MorphiaGreetingDomain retrieveGreetingFor(String greetingId) {
        Query<MorphiaGreetingDomain> query = datastore.createQuery(MorphiaGreetingDomain.class);
        return query.filter("id", greetingId).get();
    }

    public void deleteGreetingFor(String greetingId) {
        Query<MorphiaGreetingDomain> query = datastore.createQuery(MorphiaGreetingDomain.class);
        Query<MorphiaGreetingDomain> morphiaGreetingDomain = query.filter("id", greetingId);
        WriteResult delete = datastore.delete(morphiaGreetingDomain);
    }

    public MorphiaGreetingDomain update(MorphiaGreetingDomain morphia) {
        Query<MorphiaGreetingDomain> query = datastore.createQuery(MorphiaGreetingDomain.class).filter("id", morphia.getId());
        UpdateOperations<MorphiaGreetingDomain> updateOperations = datastore.createUpdateOperations(MorphiaGreetingDomain.class);
        updateOperations.set("name", morphia.getName());
        updateOperations.set("message", morphia.getMessage());
        UpdateResults updateResults = datastore.updateFirst(query, updateOperations);
        return morphia;
    }

    public boolean isGreetingExist(String greetingId) {
        Query<MorphiaGreetingDomain> query = datastore.createQuery(MorphiaGreetingDomain.class);
        return null != query.filter("id", greetingId).get() ? true : false;
    }
}

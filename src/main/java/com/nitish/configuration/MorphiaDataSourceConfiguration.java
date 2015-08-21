package com.nitish.configuration;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class MorphiaDataSourceConfiguration {

    @Autowired
    private ExternalConfiguration externalConfiguration;

    @Bean
    public Datastore datastore() throws UnknownHostException {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.nitish.domain");
        MongoClient mongoClient = new MongoClient(externalConfiguration.getHostName());
        return morphia.createDatastore(mongoClient, externalConfiguration.getDb());
    }

}

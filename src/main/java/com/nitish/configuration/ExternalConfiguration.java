package com.nitish.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExternalConfiguration {

    private static  final Logger logger = Logger.getLogger(ExternalConfiguration.class);

    @Value("${mongo.db.name}")
    private String db;
    @Value("${mongo.db.host}")
    private String hostName;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

   @PostConstruct
    public  void postContructForProperties(){
       logger.info("Database Name = "+getDb());
       logger.info("Database Host Name = "+getHostName() );
   }
}

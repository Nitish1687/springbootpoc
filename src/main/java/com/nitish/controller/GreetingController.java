package com.nitish.controller;

import com.nitish.domain.Greeting;
import com.nitish.service.MorphiaGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class GreetingController {

    @Autowired
//    private GreetingServiceInterface greetingServiceInterface;
    private MorphiaGreetingService greetingServiceInterface;

    @RequestMapping(value = "/greeting/save", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Greeting> createGreeting(@RequestBody Collection<Greeting> greetings) {
        return greetingServiceInterface.createGreeting(greetings);
    }

    @RequestMapping(value = "/greeting/all", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> showGreeting() {
        Collection<Greeting> allGreeting = greetingServiceInterface.getAllGreeting();
        if (!CollectionUtils.isEmpty(allGreeting)) {
            return new ResponseEntity<>(allGreeting, OK);
        }
        return new ResponseEntity("Greeting Is Not Exist", NOT_FOUND);
    }

    @RequestMapping(value = "/greeting/{greetingId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Greeting showGreetingFor(@PathVariable String greetingId) {
        return greetingServiceInterface.getGreetingFor(greetingId);
    }

    @RequestMapping(value = "/greeting/{greetingId}/delete", method = DELETE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteGreetingFor(@PathVariable String greetingId) {
        if (greetingServiceInterface.isGreetingExistFor(greetingId)) {
            greetingServiceInterface.deleteGreetingFor(greetingId);
            return new ResponseEntity("SuccessFully Deleted Greeting", OK);
        }
        return new ResponseEntity(format("Error While Deleting Entry for %s", greetingId), NOT_FOUND);
    }

    @RequestMapping(value = "greeting/{greetingId}/update", method = PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateGreetingFor(@PathVariable String greetingId, @RequestBody Greeting greeting) {
        if (greetingServiceInterface.isGreetingExistFor(greetingId)) {
            greetingServiceInterface.updateGreetingIntoDb(greeting);
            return new ResponseEntity<>(ACCEPTED);
        }
        greetingServiceInterface.createGreeting(asList(greeting));
        return new ResponseEntity("Greeting Successfully Created", CREATED);
    }

}

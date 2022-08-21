package com.axceldev.operators.handlers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HandlerError {
    
    public static final Logger log = LoggerFactory.getLogger(HandlerError.class);

    public void retry() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .concatWith(Flux.error(new RuntimeException("Un error")))
            .retry(1)
            .doOnNext( person -> log.info( person.toString() ) )
            .subscribe();
    }

    public void errorReturn() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .concatWith(Flux.error(new RuntimeException("Un error")))
            .onErrorReturn(new Person(0, "NN", 0))
            .subscribe( person -> log.info( person.toString() ) );
    }

    public void errorResume() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .concatWith( Flux.error( new RuntimeException("Un error") ) )
            .onErrorResume( exception -> Mono.just( new Person(0, "NN", 0) ) )
            .subscribe( person -> log.info( person.toString() ) );
    }

    public void errorMap() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .concatWith( Flux.error( new RuntimeException("Un error") ) )
            .onErrorMap( exception -> new InterruptedException( exception.getMessage() ))
            .subscribe( person -> log.info( person.toString() ) );
    }
}

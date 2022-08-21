package com.axceldev.operators.condition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import reactor.core.publisher.Flux;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;

public class Conditional {
    
    public static final Logger log = LoggerFactory.getLogger(Conditional.class);

    public void defaultIfEmpty() {
        Mono.just( new Person(1, "Cristian", 24) )
        //Mono.empty()
        //Flux.empty()
            .defaultIfEmpty( new Person(00, "default", 99) )
            .subscribe( person -> log.info( person.toString() ) );
    }

    public void takeUntil() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 33)
												);

		Flux.fromIterable(personList)
            .takeUntil(  objPerson -> objPerson.getAgePerson() > 23 )
            .subscribe( person -> log.info( person.toString() ) );
    }

    public void timeOut() throws InterruptedException {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 33)
												);

		Flux.fromIterable(personList)
            .delayElements( Duration.ofSeconds(1) )
            .timeout( Duration.ofSeconds( 2 ) )
            .subscribe( person -> log.info( person.toString() ) );

            Thread.sleep(10000);
    }

}

package com.axceldev.operators.transformation;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transform {
    
    private static final Logger log = LoggerFactory.getLogger( Transform.class );

    public void map() {

        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .map(p -> {
                p.setAgePerson(p.getAgePerson() + 10);
                return p;
            })
            .subscribe( p -> log.info( p.toString() ) ); 

        /*Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx1 = fx.map( x -> x + 10);
        fx1.subscribe( x -> log.info( " X: " + x ));*/

    }
    
    public void flagMap() {

        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .flatMap( p -> {
                p.setAgePerson(p.getAgePerson() + 10);
                return Mono.just(p);
            })
            .subscribe( p -> log.info( p.toString() ) );
    }

    public void groupBy() {

        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												); 

		Flux.fromIterable(personList).groupBy( Person::getIdPerson )
                                     .flatMap( idFlux -> idFlux.collectList() )
                                     .subscribe( p -> log.info( p.toString() ) );
    }
}

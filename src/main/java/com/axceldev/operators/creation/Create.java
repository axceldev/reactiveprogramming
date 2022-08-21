package com.axceldev.operators.creation;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Create {
    
    private static final Logger log = LoggerFactory.getLogger( Create.class );

    public void justFrom() {
        Mono.just( new Person(1, "axcel", 24) );
        //Flux.just(new ArrayList<>());
        //Observable.just(item);
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range() {
        Flux.range(0, 3)
            .doOnNext( i -> log.info( "i: " + i ) )
            .subscribe();
    }

    public void repeat() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .repeat(3)
            .subscribe( p -> log.info( p.toString() ));

        /*Mono.just( new Person(1, "Axceldev", 24) )
			.repeat(3)
            .subscribe( x -> log.info( x.toString() ) );*/
    }
}

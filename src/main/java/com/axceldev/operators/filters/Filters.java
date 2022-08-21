package com.axceldev.operators.filters;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import reactor.core.publisher.Flux;

public class Filters {

    private static final Logger log = LoggerFactory.getLogger( Filters.class );

    public void filter() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(4, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .filter(p -> p.getAgePerson() > 25)
            .subscribe( p -> log.info( p.toString() ) ); 
    }

	public void distinct() {
		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(3, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);
		Flux.fromIterable(personList)
			.distinct(Person::getIdPerson)
			.subscribe( p -> log.info( p.toString() ) ); 
											
	}

	public void take() {
		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(3, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);
		Flux.fromIterable(personList)
			.take(2)
			.subscribe( p -> log.info( p.toString() ) );
	}

	public void takeLast() {
		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(3, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);
		Flux.fromIterable(personList)
			.takeLast(1)
			.subscribe( p -> log.info( p.toString() ) );
	}

	public void skip() {
		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(3, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);
		Flux.fromIterable(personList)
			.skip(1)
			.subscribe( p -> log.info( p.toString() ) );
	}

	public void skipLast() {
		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(1, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(3, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);
		Flux.fromIterable(personList)
			.skipLast(1)
			.subscribe( p -> log.info( p.toString() ) );
	}
}

package com.axceldev.operators.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;

import reactor.core.publisher.Flux;

public class Math {

    public static final Logger log = LoggerFactory.getLogger(Math.class);

    public void average() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .collect( Collectors.averagingInt( Person::getAgePerson ) )
            .subscribe( person -> log.info( "Average: " + person ) );
    }

    public void count() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .count()
            .subscribe( person -> log.info( "Count: " + person ) );
    }

    public void min() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .collect( Collectors.minBy( Comparator.comparing(Person::getAgePerson) ) )
            .subscribe( person -> log.info( "Min: " + person.get().toString() ) );
    }

    public void sum() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .collect( Collectors.summingInt(Person::getAgePerson))
            .subscribe( person -> log.info( "Sum: " + person ) );
    }

    public void summarizing() {
        List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
            .collect( Collectors.summarizingInt(Person::getAgePerson))
            .subscribe( person -> log.info( "summarizing: " + person ) );
    }
}

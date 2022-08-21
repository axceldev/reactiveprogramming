package com.axceldev.operators.combine;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axceldev.model.Person;
import com.axceldev.model.Sale;

import reactor.core.publisher.Flux;

public class Combine {

    private static final Logger log = LoggerFactory.getLogger( Combine.class );

    public void merge() {
        List<Person> personListOne  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(4, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);

        List<Person> personListTwo  = Arrays.asList(
												 new Person(1, "Frank", 24),
												 new Person(2, "Robert", 28),
												 new Person(3, "Lopez", 29),
												 new Person(4, "comodos", 30),
												 new Person(5, "polidar", 32),
												 new Person(6, "hernandez", 30)
											 	  );

        List<Sale> saleListOne = Arrays.asList( 
												new Sale(1, LocalDateTime.now()),
												new Sale(2, LocalDateTime.now()),
												new Sale(3, LocalDateTime.now()),
												new Sale(4, LocalDateTime.now()),
												new Sale(5, LocalDateTime.now())
											  );

		Flux<Person> personFluxOne = Flux.fromIterable(personListOne);
		Flux<Person> personFluxTwo = Flux.fromIterable(personListTwo);
		Flux<Sale> SaleFluxOne = Flux.fromIterable(saleListOne);

        Flux.merge(personFluxOne, personFluxTwo, SaleFluxOne)
            .subscribe( p -> log.info( p.toString() ) ); 
    }

	public void zip() {
		        List<Person> personListOne  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(4, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);

        List<Person> personListTwo  = Arrays.asList(
												 new Person(1, "Frank", 24),
												 new Person(2, "Robert", 28),
												 new Person(3, "Lopez", 29),
												 new Person(4, "comodos", 30),
												 new Person(5, "polidar", 32),
												 new Person(6, "hernandez", 30)
											 	  );

        /*List<Sale> saleListOne = Arrays.asList( 
												new Sale(1, LocalDateTime.now()),
												new Sale(2, LocalDateTime.now()),
												new Sale(3, LocalDateTime.now()),
												new Sale(4, LocalDateTime.now()),
												new Sale(5, LocalDateTime.now())
											  );*/
		Flux<Person> personFluxOne = Flux.fromIterable(personListOne);
		Flux<Person> personFluxTwo = Flux.fromIterable(personListTwo);
		//Flux<Sale> SaleFluxOne = Flux.fromIterable(saleListOne);

		Flux.zip(personFluxOne, personFluxTwo, (personOne, personTwo) -> String.format("[FluxPersonOne]: %s, [FluxPersonTwo]: %s", personOne, personTwo))
        	.subscribe( p -> log.info( p.toString() ) ); 
	}

	public void zipWith() {
 		List<Person> personListOne  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 28),
												 new Person(3, "frances", 29),
												 new Person(4, "colombo", 30),
												 new Person(5, "peñol", 32),
												 new Person(6, "fernando herrera", 30)
												);

        List<Person> personListTwo  = Arrays.asList(
												 new Person(1, "Frank", 24),
												 new Person(2, "Robert", 28),
												 new Person(3, "Lopez", 29),
												 new Person(4, "comodos", 30),
												 new Person(5, "polidar", 32),
												 new Person(6, "hernandez", 30)
											 	  );

        /*List<Sale> saleListOne = Arrays.asList( 
												new Sale(1, LocalDateTime.now()),
												new Sale(2, LocalDateTime.now()),
												new Sale(3, LocalDateTime.now()),
												new Sale(4, LocalDateTime.now()),
												new Sale(5, LocalDateTime.now())
											  );*/

		Flux<Person> personFluxOne = Flux.fromIterable(personListOne);
		Flux<Person> personFluxTwo = Flux.fromIterable(personListTwo);
		//Flux<Sale> SaleFluxOne = Flux.fromIterable(saleListOne);

        personFluxOne.zipWith(personFluxTwo, (personOne, personTwo) -> String.format("[FluxPersonOne]: %s, [FluxPersonTwo]: %s", personOne, personTwo))
            .subscribe( p -> log.info( p.toString() ) ); 
	}
}

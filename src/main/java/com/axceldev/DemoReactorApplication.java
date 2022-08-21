package com.axceldev;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.axceldev.model.Person;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just( new Person(1, "Axceldev", 24) )
			.doOnNext( p -> log.info("[Reactor] Person:" + p ) )
			.subscribe( p -> log.info("[Reactor] Person:" + p ) );
	}

	public void rxjava2() {
		Observable.just( new Person(1, "Axceldev", 24) )
				  .doOnNext( p -> log.info("[Rxjava2] Person:" + p ) )
				  .subscribe( p -> log.info("[Rxjava2] Person:" + p ) );
	}

	public void mono() {
		Mono.just( new Person(1, "Axceldev", 24) )
			.subscribe( p -> log.info( "[Mono] person: " + p.toString() ) );
  	}

	public void flux() {

		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux.fromIterable(personList)
			.subscribe( p -> log.info( "[Flux] persons: " + p.toString() ) );
	}

	public void fluxAsMono() {

		List<Person> personList  = Arrays.asList(
												 new Person(1, "Axceldev", 24),
												 new Person(2, "Emelec", 30),
												 new Person(3, "fernando herrera", 30)
												);

		Flux<Person> fx = Flux.fromIterable(personList);
		fx.collectList().subscribe( list -> log.info("[FLUX AS MONO]" + list.toString() ) ); 
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//[TIPO OPERADORES] : MATEMATICOS
		//Math app = new Math();
		//app.summarizing();
		//app.sum();
		//app.min();
		//app.count();
		//app.average();

		//[TIPO OPERADORES] : CONDICIÓN
		//Conditional app = new Conditional();
		//app.timeOut();
		//app.takeUntil();
		//app.defaultIfEmpty();

		//[TIPO OPERADORES] : CONTROL DE ERRORES
		//HandlerError app = new HandlerError();
		//app.errorMap();
		//app.errorResume();
		//app.errorReturn();
		//app.retry();

		//[TIPO OPERADORES] : COMBINACIÓN
		//Combine app = new Combine();
		//app.zipWith();
		//app.zip();
		//app.merge();

		//[TIPO OPERADORES] : FILTRADO
		//Filters app = new Filters();
		//app.skipLast();
		//app.skip();
		//app.takeLast();
		//app.take();
		//app.distinct();
		//app.filter();
		
		//[TIPO OPERADORES] : TRANSFORMACIÓN
		//Transform app = new Transform();
		//app.flagMap();
		//app.groupBy();
		//app.map();
		
		//[TIPO OPERADORES] : CREACIONALES
		//Create app = new Create();
		//app.repeat();  
		//fluxAsMono();
		//mono();
		//flux();
		//reactor();
		//rxjava2();
	}

	

}

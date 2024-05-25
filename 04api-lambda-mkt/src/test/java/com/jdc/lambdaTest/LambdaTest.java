package com.jdc.lambdaTest;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaTest {
	
	//@Test
	void lambdaTest() {
//		Worker w = name ->  name;
//		String name = w.doWork("Aung Aung");
//		System.out.println("Name : " + name);
		
		Worker w = name -> System.out.println("Name : " + name);
		w.doWork("Aung Aung");
		
		Worker w1 = Employee :: new;
		w1.doWork("Constructor");
		
		Employee e = new Employee("ss");
		Worker w2 = e :: useIntstance;
		w2.doWork("Instance method");
		
		Worker w3 = Employee :: useStatic;
		w3.doWork("Static Method");
	}
	
	//@Test
	void useDefaultFunction() {
		Consumer<String> c = a -> System.out.println("Lambda : " + a);
		c.accept("ss");
		Consumer<String> c1 = Employee :: useStatic;
		c1.accept("Consumer");
	}
	
	@Test
	void useMethodArg() {
		Consumer<String> c1 = a -> System.out.println(a);
		//c1.accept("ss");
		Consumer<Consumer<String>> c2 = con -> con.accept("This is arg");
		c2.accept(c1);
		
		Function<Function<String, Integer>, Integer> f1 = fun -> fun.apply("40");
		int res = f1.apply(a -> Integer.valueOf(a) + 20);
		System.out.println(res);
		
		Function<String, Integer> fun = s -> Integer.valueOf(s);
		Function<String, Function<String , Integer>> f2 = str -> fun;
		Function<String, Integer> fun2 = f2.apply("50");
		int i = fun2.apply("40");
		System.out.println(i);
	}
}

class Employee {
	
	Employee(String name){
		System.out.println("Using Constructor : " + name);
	}
	
	void useIntstance(String name) {
		System.out.println("Using Instance : " + name);
	}
	
	static void useStatic(String name) {
		System.out.println("Using Static : " + name);
	}
}

@FunctionalInterface
interface Worker{
	void doWork(String name);
	
	default void doSomething() {
		System.out.println("Do Something.");
	}
	
}

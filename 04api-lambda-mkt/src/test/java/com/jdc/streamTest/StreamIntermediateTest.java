package com.jdc.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class StreamIntermediateTest {
	
	//@Test
	void filter() {
		IntStream.range(1, 20)
		.filter(even -> even % 2 == 0)
		.limit(5)
		.skip(2)
		.forEach(System.out::println);
	}
	
	//@Test
	void sorted() {
		Arrays.asList(3,4,5,5,6,2,2,2,7)
		.stream()
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
	}
	
	//@Test
	/*
	 * void mapAndFlatMap() { List.of("5","3","8","1","3") .stream() .mapToInt(i ->
	 * Integer.parseInt(i) }
	 */
	
	
	
	
	
}

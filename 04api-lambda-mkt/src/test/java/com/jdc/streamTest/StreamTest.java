package com.jdc.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamTest {
	
	@Test
	void fromGen_iterate() {
		IntStream.generate(() -> 1)
		.limit(6)
		.forEach(a -> System.out.println(a));
		
		DoubleStream.generate(Math::random)
		.limit(6)
		.mapToInt(i -> Double.hashCode(i))
		.forEach(a -> System.out.println(a));
		
		DoubleStream.iterate(1, d -> d + 1).limit(5).forEach(System.out::println);
		
	}
	
	//@Test
	void fromRange() {
		var res1 = IntStream.range(1, 10).sum();
		System.out.println(res1);
		
		var res2 = LongStream.range(1, 10).sum();
		System.out.println(res2);
	}
	
	//@Test
	void fromArray_Collection() {
		int [] array = {1,2,3,4,5,6,7,8,9};
		List<Integer> list = List.of(1,2,3,4);
		
		Arrays.stream(array).forEach(a -> System.out.println(a + ","));
		list.stream().forEach(a -> System.out.println(a + ","));
		
	}
	
	//@Test
//	void useBeforeAndAfter() {
//		System.out.println("Before Stream : " + beforeStream(array));
//		System.out.println("After Stream : " + useStream(array));
//	}
	
	int useStream(int[] array) {
		return Arrays.stream(array).sum();
	}
	
	int beforeStream(int [] array) {
		int res = 0;
		for (int i : array) {
			res += i;
		}
		return res;
	}
}

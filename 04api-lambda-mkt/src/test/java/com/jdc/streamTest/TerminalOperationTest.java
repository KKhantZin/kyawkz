package com.jdc.streamTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class TerminalOperationTest {
	
	//@Test
	void checking() {
		var res = List.of(4,4,2,6,8,8,2,6)
					.stream()
					.mapToInt(i -> i)
					.noneMatch(a -> a % 2 != 0);
		System.out.println(res);
	}
	
	@Test
	void getResult() {
		var list = List.of(3,4,5)
		.stream()
		.findFirst();
		
		System.out.println(list);
	}
	
	@Test
	void getResultV2() {
		assertThrows(
				NoSuchElementException.class,
				() -> List.of(6,4,5).stream()
				.filter(i -> i > 6)
				.findAny().get());
				
		var res = List.of(8,5,2,1,5,6,8).stream().sorted().findAny().get();
		System.out.println(res);
		
		var res1 = List.of(2,3,4,5).stream()
				.mapToInt(i -> i).max().getAsInt();
				//.min((a,b) -> a > b ? 1 : -1).get();
		System.out.println(res1);
		
		var list = List.of(54,3,2,543,6).stream().collect(Collectors.toList());
		System.out.println(list);
		
		var res2 = List.of(3,4,5).stream().reduce((a,b) -> a + b).get();
		System.out.println(res2);
		
	}
}

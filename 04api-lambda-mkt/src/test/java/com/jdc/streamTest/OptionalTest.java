package com.jdc.streamTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalTest {
	
	Optional<String> getValue(String name){
		return Optional.ofNullable(name);
	}
	
	@Test
	void TestOptional() {
		//assertThrows(NullPointerException.class, () -> getValue(null));
		assertThrows(NullPointerException.class, 
				() -> getValue(null).orElseThrow(() -> new NullPointerException()));
		assertEquals("test", getValue("test").get());
		assertEquals("val", getValue("val").orElse("other"));
	}

}

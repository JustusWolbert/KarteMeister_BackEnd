package com.KarteMeister.KMBackEnd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KmBackEndApplicationTests {
	int a = 1;
	int b = 1; 
	
	@Test
	void contextLoads() {
		assertEquals(a,b);
	}

}

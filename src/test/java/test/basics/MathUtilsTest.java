package test.basics;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before all method");
	}
	
	@BeforeEach
	void intit() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("After each cleanup");
	}
	
	@Test
	@Disabled
	@DisplayName("Testing test method")
	void test() {
		fail("This test should be disabled");
	}
	
	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, 
				() -> mathUtils.divide(1, 0), 
				"Divide by zero should throw");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testComputeCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), 
				"Should return right circle area");
	}
}

package test.basics;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("When running MathUtils")
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
	
	@Nested
	@DisplayName("AddTest Class")
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("Testing add pos method")
		void testAddPositive() {
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual, "shoul return the right sum");
		}
		
		@Test
		@DisplayName("Testing add neg method")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			//lambda for more optimization:
			assertEquals(expected, actual, () -> "shoul return the right sum" + expected + " but returned " + actual);
		}
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
	@DisplayName("Testing multiply method")
	@Tag("Math")
	void testMultiply() {
		//assertEquals(4, mathUtils.multiply(2, 2), "should return the right product");
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2), "should return the right product"),
				() -> assertEquals(0, mathUtils.multiply(2, 0), "should return the right product"),
				() -> assertEquals(-2, mathUtils.multiply(2, -1), "should return the right product")
				);
	}
	
	@Test
	@Tag("Math")
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, 
				() -> mathUtils.divide(1, 0), 
				"Divide by zero should throw");
	}
	
	@Test
	//@EnabledOnOs(OS.LINUX)
	//@RepeatedTest(3)
	@Tag("Circle")
	void testComputeCircleRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), 
				"Should return right circle area");
	}
}

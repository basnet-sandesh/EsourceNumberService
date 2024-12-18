package com.esource.takehome.assignment.number_service;

import com.esource.takehome.assignment.number_service.Service.NumberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class NumberServiceApplicationTests {

	@Autowired
	private NumberService numberService;

	@Test
	public void testFindAvailableNumbers() {
		int[] array1 = {1, 2, 3};
		int[] array2 = {4, 5, 6};
		int[] array3 = {7, 8, 9};

		List<Integer> availableNumbers = numberService.findAvailableNumbers(array1, array2, array3);

		// Check that 0 and 10 which were not in any of arrays are in the result
		assertTrue(availableNumbers.contains(0));
		assertTrue(availableNumbers.contains(10));
	}

	@Test
	public void testFindLargestPrime() {
		List<Integer> numbers = Arrays.asList(2, 3, 17, 37, 19);
		Integer largestPrime = numberService.findLargestPrime(numbers);

		assertEquals(37, largestPrime);
	}

}

package com.esource.takehome.assignment.number_service;

import com.esource.takehome.assignment.number_service.Service.NumberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class NumberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberServiceApplication.class, args);

		NumberService numberService = new NumberService();

		// Generate random arrays
		int[] array1 = numberService.generateRandomArray();
		int[] array2 = numberService.generateRandomArray();
		int[] array3 = numberService.generateRandomArray();

		// Display numbers present in arrays
		System.out.println("Array 1: " + Arrays.toString(array1));
		System.out.println("Array 2: " + Arrays.toString(array2));
		System.out.println("Array 3: " + Arrays.toString(array3));

		// Find available numbers
		List<Integer> availableNumbers = numberService.findAvailableNumbers(array1, array2, array3);
		System.out.println("Available Numbers: " + availableNumbers);

		// Find the largest prime number out of list
		Integer largestPrime = numberService.findLargestPrime(availableNumbers);
		System.out.println("Largest Prime: " + (largestPrime != null ? largestPrime : "No primes found"));
	}

}

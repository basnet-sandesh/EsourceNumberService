package com.esource.takehome.assignment.number_service.Service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NumberService {

  private final Random random = new Random();

  // Generate a random array with 15 numbers in range [0-50]
  public int[] generateRandomArray() {
    return random.ints(15, 0, 51).toArray();
  }

  // Find numbers in range [0-50] not present in any of the arrays
  public List<Integer> findAvailableNumbers(int[]... arrays) {
    Set<Integer> allNumbers = new HashSet<>();
    for (int[] array : arrays) {
      for (int num : array) {
        allNumbers.add(num);
      }
    }
    return IntStream.rangeClosed(0, 50)
        .filter(num -> !allNumbers.contains(num))
        .boxed()
        .collect(Collectors.toList());
  }

  // Check if a number is prime
  private boolean isPrime(int number) {
    if (number < 2) return false;
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) return false;
    }
    return true;
  }

  // Find the largest prime number in the given list
  public Integer findLargestPrime(List<Integer> numbers) {
    return numbers.stream()
        .filter(this::isPrime)
        .max(Integer::compareTo)
        .orElse(null);
  }
}

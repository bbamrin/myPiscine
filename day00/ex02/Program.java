package com.company;

import java.util.Scanner;


public class Main {
	public static int getDigitSum(int number) {
		int sum;

		sum = 0;
		while (number > 0)
		{
			sum += + number % 10;
			number /= 10;
		}
		return (sum);
	}

	public static boolean isPrime(int number)
	{
		int     i;

		i = 2;
		if (number <= 1)
			return(false);
		while (i * i <= number) {
			if (number % i == 0) {
				return (false);
			}
			i++;
		}
		return (true);
	}

	public static void main(String[] args) {
		Scanner scanner;
		int     coffeeCount;

		scanner = new Scanner(System.in);
		coffeeCount = 0;
		while (scanner.hasNextInt()) {
			if (isPrime(getDigitSum(scanner.nextInt()))) {
				coffeeCount++;
			}
		}
		System.out.printf("Count of coffee-request - %d\n", coffeeCount);
	}
}

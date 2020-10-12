package com.company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner;
		int     num;
		int     i;
		int     stepCount;

		scanner = new Scanner(System.in);
		num = scanner.nextInt();
		i = 2;
		stepCount = 1;
		if (num <= 1)
		{
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
		while (i * i <= num)
		{
			if (num % i == 0)
			{
				System.out.printf("%s %d\n", "false", stepCount);
				System.exit(-1);
			}
			stepCount++;
			i++;
		}
		System.out.printf("%s %d\n", "true", stepCount);
	}
}

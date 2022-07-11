package primeNumbers;

import java.util.Arrays;

public class PrimeNumbers {
	
	public static void main (String args[]) {
		int currentNum = 3; //The current number to be checked.
		int previousElement = 0; //The location of the last element in the array.
		boolean isPrime = true; //Relays whether the number is a prime number or not.
		int primeList[] = new int[100]; //The list of all prime numbers found so far.
		Arrays.fill(primeList, 2);
		
		//The while loop counts each prime number, until there are 100 found.
		while (previousElement < 99) {
			//Checks if the number is prime.
			isPrime = checkPrime(currentNum, isPrime, primeList);
			
			//If the number is prime. Adds the number to the array and increments the previousElement count.
			if (isPrime == true) {
				previousElement++;
				primeList[previousElement] = currentNum;
			}
			currentNum++; //Moves on to the next number.
		}
		System.out.println("The first 100 prime numbers are: ");
		printPrime (primeList); //Prints the array line by line.
	}
	
	static boolean checkPrime(int currentNum, boolean isPrime, int[] primeList) {
		isPrime = true; //Resets the prime number boolean for each number.
		double squareRoot = Math.sqrt(currentNum);
		//The for loop checks each prime number that came before the current number.
		//If any of the prime numbers are divisible by the current number, the program moves on.
		for (int i = 0; primeList[i] <= squareRoot; i++) {
			if (currentNum % primeList[i] == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	static void printPrime (int[] primeList) {
		for (int j = 0; j < 100; j++) {
			System.out.println(primeList[j]);
		}
	}
}

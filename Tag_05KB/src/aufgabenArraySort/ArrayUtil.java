package aufgabenArraySort;

import java.util.Arrays;
import java.util.Scanner;

public abstract class ArrayUtil {
	private static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	// fills an array ascending
	public static void fillArrayAscending(int[] array) {
		// fill array ascending
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

	// fills an array descending
	public static void fillArrayDescending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.abs(i - 10);
		}
	}

	// fills an array with pseudo random values
	public static void fillArrayRandom(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) (Math.random() * 10)) + 1;
		}
	}

	// fills an array with pseudo random values between 0 and 50000
	public static void fillBigArrayRandom(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) (Math.random() * 50001));
		}
	}

	// prints the values of an array
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	// takes an array and returns the sum of all values
	public static int sumOfArray(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	// takes an array and returns the average value
	public static double avgOfArray(int[] array) {
		double avg = 0;
		avg = (double) sumOfArray(array) / array.length;
		return avg;
	}

	// takes an array and prints the lowest and highest value
	public static void minMaxOfArray(int[] array) {
		int min = array[0];
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}

		}
		System.out.println("Kleinste: " + min + ", Größte: " + max);
	}

	// takes an array and returns the lowest value
	public static int minOfArray(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}

		}
		return min;
	}

	// takes an array and returns the highest value
	public static int maxOfArray(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}

		}
		return max;
	}

	// takes an array and swaps values of index array[i] and index array[j]
	public static void swapArrayOrder(int[] array) {
		// variable that addresses opposite index to i
		int j = array.length - 1;
		// works for even and uneven array, cause in uneven arrays the middle position
		// always stays the same
		for (int i = 0; i < array.length / 2; i++) {
			// cup holds the variable of arrayA so that A[i] can be overwritten by B[j] and
			// afterwards B[j] gets the value of A[i] from cup
			int cup = array[i];
			array[i] = array[j];
			array[j] = cup;
			j--;
		}
	}
	// takes an array and searches for a value that can be chosen by the user
	public static void searchNumber(int[] array) {
		//saves the user input 
		String input = null;
		//number is converted from the user input, counter saves the amount of matches
		int number = 0, counter = 0;
		//holds the index of matches
		int index[] = new int[10000];
		//flag to secure correct user input
		boolean isANumber = false;
		
		//info message for the user, using two methods returning lowest and highest value of the array 
		System.out.println("Wählen Sie eine Ganzzahl zwischen " + minOfArray(array) + " und " + maxOfArray(array)
				+ ", damit ich sie im Array suchen kann: ");
		//user input in a loop, that runs until input matches integer and parses the string to integer
		while (!isANumber) {
			try {
				input = sc.next();
				number = Integer.parseInt(input);
				isANumber = true;
			//if the parseInt throws an exception the user gets informed and the loop starts again	
			} catch (Exception e) {

				System.out.println("Ihre Eingabe ist keine Ganzzahl! Bitte " + "wiederholen Sie Ihre Eingabe :");
				continue;
			}
		}
		//test if the given number is within the value range
		while (number < minOfArray(array) || number > maxOfArray(array) || !isANumber || input == null) {

			System.out.println("Ihre Zahl liegt außerhalb des Zahlenbereichs von " + minOfArray(array) + " bis "
					+ maxOfArray(array) + ", " + "oder ist keine Ganzzahl! \n"
					+ "Bitte geben Sie eine neue Zahl im Gültigkeitsbereich ein: ");

			try {
				input = sc.next();
				number = Integer.parseInt(input);
				isANumber = true;
			} catch (Exception e) {
				isANumber = false;
				continue;
			}

		}
		//start of the search
		System.out.println("Ich suche jetzt nach der " + input + " im Array!\n");
		//outer for-loop to look for the given number
		outer: for (int i = 0; i < array.length; i++) {
			//string to hold the choice of the user if he wants to continue, break, or search the whole array
			String choice = null;
			//in case number has been found
			if (number == array[i]) {
				index[counter] = i;

				System.out.println("Die gesuchte Zahl wurde im Array an Index " + index[counter++] + " gefunden!\n");
				//user can choose how to proceed
				while (choice == null || !choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("j") && !choice.equalsIgnoreCase("n") ) {
					System.out.println("Soll nach weiteren Vorkommen im Array gesucht werden?");
					System.out.println(
							"Geben Sie \"j\" für Ja, \"n\" für Nein, oder \"a\" zum Durchsuchen des gesamten Arrays ein: ");

					choice = sc.next();
					//guaranty that the string is not empty and a, j or n has been selected
					if (choice == null || !choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("j") && !choice.equalsIgnoreCase("n") ) {
						System.out.println("Sie haben keine gültige Eingabe vorgenommen!");
						continue;
					}
				}
				//return to next iteration of outer
				if (choice.equalsIgnoreCase("j")) {
					continue;
				//initializes the next iteration in the search pattern and after finishing ends outer 	
				} else if (choice.equalsIgnoreCase("a")) {
					i++;
					for (; i < array.length; i++) {
						if (number == array[i]) {
							index[counter] = i;
							counter++;
						}
					}
					break outer;
				//	in case of "n", outer ends immediately
				} else {
					break outer;
				}

			}
		}
		//giving results
		System.out.println("Die Suche führte zu folgendem Ergebnis:\n");
		System.out.println("Die gesuchte Zahl " + input + " kam " + counter + " mal im Array vor.");
		if (counter > 0) {
			System.out.print("Sie befindet sich ");
			if (counter == 1) {
				System.out.print("an Indexposition: ");
			}else {
				System.out.print("an den Indexpositionen: ");
			}
			int i = 0;
			while (index[i] > 0) {
				System.out.print("[" + index[i] + "]");
				i++;
			}
		}
	}
}

/*
 * is so
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package aufgabenArray.aufgabenArraySort;

import java.util.Arrays;
import java.util.Random;

public class LottoTip {

	public static void fuehrMichZumSchotter() {
		int[] tip = new int[6];
		boolean foundDuplicate = false;
		outer: while (!foundDuplicate) {
			for (int i = 0; i < tip.length; i++) {
				int newTip = ((int) (Math.random() * 7));
				tip[i] = newTip;
			}
			for (int i = 0; i < tip.length; i++) {
				for (int j = 0; j < tip.length; j++) {
					if (tip[i] != tip[j]) {
						foundDuplicate = false;

					} else {
						foundDuplicate = true;
						continue outer;
					}
				}
			}
		}
		System.out.println("Ihre Gewinnzahlen lauten:");
		ArrayUtil.printArray(tip);
	}

	public static void fillArrayRandomLotto() {

		short length = 6;

		int[] array = new int[length];

		Random random = new Random();

		// not "any" due to tests

		int limit = 49;

		for (int i = 0; i < length; i++) {

			array[i] = random.nextInt(limit) + 1;

			// runs through to test, if random number is already in array - if yes: put new

			// random number at index (by i--;)

			// upper boundary only to i (not full length of array, due to inner loop is at

			// point of i as upper boundary)

			for (int j = 0; j < i; j++) {

				if (array[j] == array[i]) {

					i--;

					continue;

				}

			}

		}

		System.out.println(Arrays.toString(array));

	}
}

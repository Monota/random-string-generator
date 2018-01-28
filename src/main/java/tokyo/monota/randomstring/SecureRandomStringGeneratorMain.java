package tokyo.monota.randomstring;

import org.apache.commons.text.RandomStringGenerator;

public class SecureRandomStringGeneratorMain {

	/**
	 * This program will run on macOS / Linux only.
	 */
	public static void main(String[] args) {

		char[][] pairs = {{'a','z'},{'0','9'},{'A','Z'},{'#','&'}};

		// Random
		RandomStringGenerator generator1 =
				new RandomStringGenerator.Builder().withinRange(pairs).build();
		System.out.println(generator1.generate(16));

		// SecureRandom (non blocking)
		RandomStringGenerator generator2 =
				new RandomStringGenerator.Builder().usingRandom(
						new TextSecureRandomNonBlockingProvider()).withinRange(pairs).build();
		System.out.println(generator2.generate(16));

		// SecureRandom (blocking)
		RandomStringGenerator generator3 =
				new RandomStringGenerator.Builder().usingRandom(
						new TextSecureRandomProvider()).withinRange(pairs).build();
		System.out.println(generator3.generate(16));
	}
}

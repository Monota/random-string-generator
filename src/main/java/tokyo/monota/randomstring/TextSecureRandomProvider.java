package tokyo.monota.randomstring;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.text.TextRandomProvider;

public class TextSecureRandomProvider implements TextRandomProvider {

	public int nextInt(int max) {
		try {
			return SecureRandom.getInstanceStrong().nextInt(max);
		} catch(NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}
}

package c.s.sample.certificate;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

public class KeyPairCom {

	/**
	 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator
	 */
	void sign() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			KeyPair keyPair =  generator.generateKeyPair();
			
			Signature signature = Signature.getInstance("NONEwithRSA");
			signature.initSign(keyPair.getPrivate());
			byte[] data = new byte[100];
			signature.update(data);
			System.out.println(data);
			byte[] sign = signature.sign();
			signature.initVerify(keyPair.getPublic());
			signature.update(data);
			System.out.println(data);
			System.out.println(signature.verify(sign));
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new KeyPairCom().sign();
	}
}

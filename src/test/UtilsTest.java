package test;

import static org.junit.Assert.*;
import org.junit.Test;
import javax.crypto.*;
import modelo.Utils;

public class UtilsTest {

	@Test
	public void testGetCipherAES() {
		SecretKey sk = Utils.getSecretKeyAES128("password", Utils.getSalt());
		Cipher cipher = Utils.getCipherAES(true, sk, null);
		assertTrue(cipher.getBlockSize() == 16);
		assertTrue(cipher.getAlgorithm().equals("AES/CBC/PKCS5Padding"));
		byte[] iv = cipher.getIV();
		assertTrue(iv.length == 16);
	}

	@Test
	public void testGetSecretKeyAES128() {
		SecretKey sk = Utils.getSecretKeyAES128("password", Utils.getSalt());
		assertTrue(sk.getAlgorithm().equals("AES"));
	}

	@Test
	public void testGetSalt() {
		byte[] salt = Utils.getSalt();
		assertTrue(salt.length == 16);
	}

	@Test
	public void testSHA1() {		
		byte[] sha1 = Utils.SHA1("emptyTextFile.txt");
		String hash = Utils.bytesToHex(sha1);
		assertTrue(hash.equals("DA39A3EE5E6B4B0D3255BFEF95601890AFD80709"));
	}

	@Test
	public void testBytesToHex() {
		byte[] test = {0x00, 0x01, 0x7f};
		String str = Utils.bytesToHex(test);
		assertTrue(str.equals("00017F"));
	}

	@Test
	public void testHexToBytes() {
		String originalString = "00017F";
		byte[] originalBytes = Utils.hexToBytes(originalString);
		String testString = Utils.bytesToHex(originalBytes);
		byte[] expectedBytes = new byte[] {0x00, 0x01, 0x7f};
		String expectedString = Utils.bytesToHex(expectedBytes);
		assertTrue(testString.equals(expectedString));
	}
	
	@Test
	public void testCheckMagic() {
		assertTrue(Utils.checkMagic(new byte[] {0x06, 0x06, 0x06, 0x06}));
		assertFalse(Utils.checkMagic(new byte[] {0x07, 0x07, 0x07, 0x07}));
	}

}

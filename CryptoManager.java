/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 3/17/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Aleazar Wolde
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int  RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for(char a: plainText.toCharArray()) {
			if(a < LOWER_RANGE || a > UPPER_RANGE) {
				return false;
			}
		}
		return true;	
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if(!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		StringBuilder encryptedText = new StringBuilder();
		final int BASE = ' ';
		final int RANGE = '_' - ' ' + 1;
		
		for(char a: plainText.toCharArray()){
			if(a >= BASE && a <= '_') {
				int shifted = (a - BASE + key)% RANGE + BASE;
				encryptedText.append((char) shifted);
			}else {
				encryptedText.append(a);
			}
			
		}
		return encryptedText.toString();
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		StringBuilder decryptedText = new StringBuilder();
		final int BASE = LOWER_RANGE;
		final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
		
		int correctKey = key % RANGE;
		
		for(char a : encryptedText.toCharArray()) {
			if(a >= LOWER_RANGE && a <= UPPER_RANGE) {
				int originalPosition = a - BASE - correctKey;
				if(originalPosition < 0) {
					originalPosition += RANGE;
			}
			char originalChar = (char) (originalPosition % RANGE +BASE);
			decryptedText.append(originalChar);
		}else {
			decryptedText.append(a);
		}
	}
	return decryptedText.toString();
		
}	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	 public static String bellasoEncryption(String plainText, String bellasoStr) {
	        StringBuilder encryptedText = new StringBuilder();
	        for (int i = 0; i < plainText.length(); i++) {
	            char currentChar = plainText.charAt(i);
	            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
	            int shiftedChar = (currentChar - LOWER_RANGE + bellasoChar) % (UPPER_RANGE - LOWER_RANGE + 1) + LOWER_RANGE;
	            encryptedText.append((char) shiftedChar);
	        }
	        return encryptedText.toString();
	    }

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		StringBuilder decrypted = new StringBuilder();
		final int BASE = ' ';
		final int RANGE = '_' - ' ' + 1;
		
		for(int index = 0; index < encryptedText.length(); index++) {
			int encryptedChar = encryptedText.charAt(index);
			int bellasoChar = bellasoStr.charAt(index % bellasoStr.length());
			int decryptedChar = encryptedChar - bellasoChar;
			
			while( decryptedChar < BASE) {
				decryptedChar += RANGE;
			}
			decryptedChar = (decryptedChar - BASE) % RANGE + BASE;
			decrypted.append((char) decryptedChar);
		}
		return decrypted.toString();
	}
}
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

import static org.junit.Assert.*;
import org.junit.Test;
public class CryptoManagerTestStudent{

	@Test
	
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("PYTHON"));
        assertTrue(CryptoManager.isStringInBounds("\"PYTHON IS FUN\""));
        assertFalse(CryptoManager.isStringInBounds("python"));
	}
    @Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("goodbye", 3));
        assertEquals("DEF", CryptoManager.caesarEncryption("ABC",3));
        assertEquals("!\"#", CryptoManager.caesarEncryption("ABC",96));
        assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
    }
    @Test
    public void testDecryptCaesar() {
        assertEquals("TESTING ANOTHER STRING", CryptoManager.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999));
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("4188;LC;>80", 300));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
    }
    @Test
    public void testEncryptBellaso() {
        assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
      
    }
    @Test
    public void testDecryptBellaso() {
   
        assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
    }
}
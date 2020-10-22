package example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** 
 * Un "bouchon" spécifique pour ce test
 */
class InversorBouchon extends Inversor {
	@Override
	public String inverse(String s) {
		switch (s) {
			case "kayak" :
				return "kayak";
			case "Bastide" :
				return "editsaB";
			default :
				return "Ne se produira pas ici";				
		}
	}	
}

public class PalindromeCheckerBouchonTest {
	// On déclare les objets nécessaires aux tests
	PalindromeCheckerDI checker;
	Inversor inversor;

	@BeforeEach
	public void setUp() {
		// On créee le "bouchon"
		inversor = new InversorBouchon();
		// On crée l'objet à tester en utilisant le bouchon
		checker = new PalindromeCheckerDI(inversor);
	}

	@AfterEach
	public void tearDown() {
		checker = null;
		inversor = null;
	}

	@Test
	public void testVraiPalindrome() {
		assertTrue(checker.estPalindrome("kayak"),
                        "'kayak' est un palindrome");
	}

	@Test
	public void testFauxPalindrome() {
		assertFalse(checker.estPalindrome("Bastide"),
                        "'Bastide' n'est pas un palindrome");
	}

}

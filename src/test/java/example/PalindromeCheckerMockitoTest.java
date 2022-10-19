package example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PalindromeCheckerMockitoTest {
	// On déclare les objets nécessaires aux tests
	PalindromeCheckerDI checker;
	Inversor inversor;

	@BeforeEach
	public void setUp() {
		// On crée le "bouchon"
		inversor = mock(Inversor.class);
		// On définit les résultats que le bouchon doit renvoyer pendant le test
		when(inversor.inverse("kayak")).thenReturn("kayak");
		when(inversor.inverse("Bastide")).thenReturn("editsaB");
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
		// On vérifie les appels de méthode reçus par le bouchon (optionnel)
		verify(inversor).inverse("kayak");
	}

	@Test
	public void testFauxPalindrome() {
		assertFalse(checker.estPalindrome("Bastide"),
                           "'Bastide' n'est pas un palindrome");
		// On vérifie les appels de méthode reçus par le bouchon (optionnel)
		verify(inversor).inverse("Bastide");
	}

}

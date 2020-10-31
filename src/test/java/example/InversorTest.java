package example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	// On déclare les objets nécessaires aux tests

	Inversor inversor;

	@BeforeAll
	public static void setUpClass() {
		// Ce code sera exécuté 1 seule fois, avant tous les tests
	}

	@AfterAll
	public static void tearDownClass() {
		// Ce code sera exécuté 1 seule fois, après tous les tests
	}

	@BeforeEach
	public void setUp() {
		// Ce code sera exécuté avant CHAQUE test
		// On initialise les objets nécessaires aux tests
		inversor = new Inversor();
	}

	@AfterEach
	public void tearDown() {
		// Ce code sera exécuté après CHAQUE test
		inversor = null;
	}

	@Test
	public void testInverse() {
		assertEquals("editsaB", inversor.inverse("Bastide"),
                        "La chaîne n'est pas correctement inversée");
	}

	@Test
	public void testForExceptionV1() {
		try {
			inversor.inverse(null); // Cette ligne doit lever une exception
			// Si on arrive ici, c'est qu'on n'a pas eu d'exception -> le test doit échouer
			fail("Cet appel doit lever une exception");
		} catch (IllegalArgumentException e) {
			// Si on arrive ici c'est normal, le test doit réussir
		}
	}

	// On documente l'exception attendue
	@Test
	public void testForExceptionV2() {
                assertThrows(IllegalArgumentException.class, () -> {
        		inversor.inverse(null); 
                }, "Cet appel doit lever une exception");
	}
}

package example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringBufferTest {
    private StringBuffer buffer;

    @BeforeEach
    public void setUp() {
        buffer = new StringBuffer("hello");
    }

    @Test
    public void testAppend() {
        buffer.append("x");
        assertEquals(6, buffer.length(), "On doit avoir 6 caractères");
        assertEquals("hellox", buffer.toString(), "Le caractère n'a pas été correctement ajouté");
    }

    @Test
    public void testDelete() {
        buffer.deleteCharAt(2);
        assertEquals(4, buffer.length(), "On doit avoir 4 caractères");
        assertEquals("helo", buffer.toString(), "Le caractère n'a pas été correctement supprimé");
    }

}


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaTest
{
    /**
     * Default constructor for test class ListaTest
     */
    public ListaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testNombre()
    {
        Lista lista1 = new Lista("mi dia");
        assertEquals("mi dia", lista1.getNombre());
    }

    @Test
    public void testCrearLista()
    {
        Lista lista1 = new Lista("semestre");
        assertEquals(lista1, lista1.getObjectLista());
    }
}





import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VistaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VistaTest
{
    /**
     * Default constructor for test class VistaTest
     */
    public VistaTest()
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
    public void testCrearTarea()
    {
        Lista lista2 = new Lista("l");
        Tarea tarea1 = new Tarea("sw", java.time.LocalDate.parse("2020-08-23"), true, lista2);
        Tarea result = tarea1.getTarea();
        assertEquals(tarea1, result);
        java.time.LocalDate localDat1 = result.fecha_entrega;
    }
}

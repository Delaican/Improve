

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TareaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TareaTest
{
    /**
     * Default constructor for test class TareaTest
     */
    public TareaTest()
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
    public void TestFavorito()
    {
        Lista lista1 = new Lista("asd");
        Tarea tarea1 = new Tarea("2020-08-23", "Tarea", true, lista1);
    }
}


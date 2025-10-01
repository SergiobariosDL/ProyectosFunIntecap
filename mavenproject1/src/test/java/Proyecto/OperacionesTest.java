/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Proyecto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Precision
 */
public class OperacionesTest {
    
    public OperacionesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getValor method, of class Operaciones.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Operaciones instance = new Operaciones();
        double expResult = 0.0;
        double result = instance.getValor();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class Operaciones.
     */
    @Test
    public void testSetValor() {
        System.out.println("setValor");
        double valor = 0.0;
        Operaciones instance = new Operaciones();
        instance.setValor(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDivisa method, of class Operaciones.
     */
    @Test
    public void testGetDivisa() {
        System.out.println("getDivisa");
        int divisa1 = 0;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.getDivisa(divisa1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDivisa method, of class Operaciones.
     */
    @Test
    public void testSetDivisa() {
        System.out.println("setDivisa");
        int divisa = 0;
        Operaciones instance = new Operaciones();
        instance.setDivisa(divisa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDivisafinal method, of class Operaciones.
     */
    @Test
    public void testGetDivisafinal() {
        System.out.println("getDivisafinal");
        int divisafinal1 = 0;
        Operaciones instance = new Operaciones();
        int expResult = 0;
        int result = instance.getDivisafinal(divisafinal1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDivisafinal method, of class Operaciones.
     */
    @Test
    public void testSetDivisafinal() {
        System.out.println("setDivisafinal");
        int divisafinal = 0;
        Operaciones instance = new Operaciones();
        instance.setDivisafinal(divisafinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultado method, of class Operaciones.
     */
    @Test
    public void testGetResultado() {
        System.out.println("getResultado");
        Operaciones instance = new Operaciones();
        double expResult = 0.0;
        double result = instance.getResultado();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultado method, of class Operaciones.
     */
    @Test
    public void testSetResultado() {
        System.out.println("setResultado");
        double resultado = 0.0;
        Operaciones instance = new Operaciones();
        instance.setResultado(resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

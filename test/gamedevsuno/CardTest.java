/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gamedevsuno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Kns1t
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of validCard method, of class Card.
     */
    @org.junit.Test
    public void testValidCardGood() {
        System.out.println("validCard Good");
        Card TestCard = new Card();
        Card FaceCard = TestCard;
        Card PlayCard = TestCard;
        Card instance = new Card();
        boolean expResult = true;
        boolean result = instance.validCard(FaceCard, PlayCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testValidCardBad() {
        System.out.println("validCard Bad");
        Card TestCard = new Card();
        Card FaceCard = TestCard;
        Card PlayCard = new Card();
        Card instance = new Card();
        boolean expResult = false;
        boolean result = instance.validCard(FaceCard, PlayCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testValidCardBoundary() {
        System.out.println("validCard Boundary");
        Card FaceCard = null;
        Card PlayCard = null;
        Card instance = new Card();
        boolean expResult = false;
        boolean result = instance.validCard(FaceCard, PlayCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Card.
     */
    @org.junit.Test
    public void testGetValueGood() {
        System.out.println("getValue Good");
        Card instance = new Card();
        Card.Value expResult = null;
        Card.Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testGetValueBad() {
        System.out.println("getValue Bad");
        Card instance = new Card();
        Card.Value expResult = null;
        Card.Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testGetValueBoundary() {
        System.out.println("getValue Boundary");
        Card instance = new Card();
        Card.Value expResult = null;
        Card.Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Card.
     */
    @org.junit.Test
    public void testSetValue() {
        System.out.println("setValue");
        Card.Value value = null;
        Card instance = new Card();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Card.
     */
    @org.junit.Test
    public void testGetColor() {
        System.out.println("getColor");
        Card instance = new Card();
        Card.Color expResult = null;
        Card.Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Card.
     */
    @org.junit.Test
    public void testSetColor() {
        System.out.println("setColor");
        Card.Color color = null;
        Card instance = new Card();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

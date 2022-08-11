/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gamedevsuno;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Kns1t
 */
public class CardDesignPrinciplesTest {
    
    public CardDesignPrinciplesTest() {
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
     * Test of CreateDeck method, of class CardDesignPrinciples.
     */
    @org.junit.Test
    public void testCreateDeck() {
        System.out.println("CreateDeck");
        ArrayList<Card> deck = null;
        CardDesignPrinciples.CreateDeck(deck);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of drawCard method, of class CardDesignPrinciples.
     */
    @org.junit.Test
    public void testDrawCard() {
        System.out.println("drawCard");
        int amt = 0;
        ArrayList<Card> deck = null;
        CardDesignPrinciples.drawCard(amt, deck);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayDeck method, of class CardDesignPrinciples.
     */
    @org.junit.Test
    public void testDisplayDeck() {
        System.out.println("displayDeck");
        CardDesignPrinciples.displayDeck();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CardDesignPrinciples.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CardDesignPrinciples.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

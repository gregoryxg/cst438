package com.csumb.cst438.a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of Game class
 * @author david wisneski
 * @veraion 1.0
 * UPDATED 5.16.2017 - Added calls to getCharInWord and getCharNotInWord to
 * ensure testing reflects the game update where a random instead of static
 * guess word is selected.
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getState method, of class Game.
     * at start of game, state should be 1.
     * a correct guess will not change the state
     * an incorrect guess will increase state by 1
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Game instance = new Game();
        int expResult = 1;
        int result = instance.getState();
        assertEquals(expResult, result);
        instance.playGame(instance.getCharInWord());//<----Call to getCharInWord()
        result = instance.getState();
        assertEquals(expResult, result);
        instance.playGame(instance.getCharNotInWord(true));//<----Call to getCharNotInWord()
        result = instance.getState();
        assertEquals(expResult+1, result);
    }

    /**
     * Test of getWord method, of class Game.
     */
    @org.junit.Test
    public void testGetWord() {
        System.out.println("getWord");
        Game instance = new Game();
        String expResult = instance.getWord();
        String result = instance.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayWord method, of class Game.
     */
    @org.junit.Test
    public void testGetDisplayWord() {
        System.out.println("getDisplayWord");
        Game instance = new Game();
        String expResult = instance.getDisplayWord();
        String result = instance.getDisplayWord();
        assertEquals(expResult, result);
        instance.playGame(instance.getCharInWord());//<----Call to getCharInWord()
        result = instance.getDisplayWord();
        assertEquals(instance.getDisplayWord(), result);

    }

    /**
     * Test of startNewGame method, of class Game.
     */
    @org.junit.Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        Game instance = new Game();
        instance.startNewGame();
        instance.playGame(instance.getCharInWord());//<----Call to getCharInWord()
        instance.playGame(instance.getCharNotInWord(true));//<----Call to getCharNotInWord()
        instance.startNewGame();
        int result = instance.getState();
        assertEquals(1,result);
 
    }

    /**
     * Test of playGame method, of class Game.
     *   correct guess should return 0 , or 1 when game is won
     *   incorrect guess should return 2, or 3 when game is lost
     */
    @org.junit.Test
    public void testPlayGame() {
        System.out.println("playGame");
        Game instance = new Game();
        char guess = instance.getCharInWord();//<----Call to getCharInWord()
        int expResult = 0;
        int result = instance.playGame(guess);
        assertEquals(expResult, result);
        result = instance.playGame(instance.getCharNotInWord(true));//<----Call to getCharNotInWord()
        assertEquals(2, result);
        result = instance.playGame(instance.getCharNotInWord(false));//<----Call to getCharNotInWord()
        assertEquals(2, result);
        result = instance.playGame(instance.getCharNotInWord(true));//<----Call to getCharNotInWord()
        assertEquals(2, result);
        result = instance.playGame(instance.getCharNotInWord(false));//<----Call to getCharNotInWord()
        assertEquals(2,result);
        result = instance.playGame(instance.getCharNotInWord(true));//<----Call to getCharNotInWord()
        assertEquals(2,result);
        result = instance.playGame(instance.getCharNotInWord(false));//<----Call to getCharNotInWord()
        assertEquals(3,result);
 
        instance.startNewGame();
        //Loop plays all the correct guesses until all '_' have been filled
        int i = 0;
        while (instance.getDisplayWord().indexOf("_") > - 1)
        {
            result = instance.playGame(instance.getWord().charAt(i));
            if (instance.getDisplayWord().indexOf("_") > - 1)
            {                
                assertEquals(0,result);
            }
            else if (instance.getDisplayWord().indexOf("_") == - 1)
            {
                assertEquals(1,result); 
            }
            i++;
        }        
    }    
}

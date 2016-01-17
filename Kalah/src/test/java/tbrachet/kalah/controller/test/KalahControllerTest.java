package tbrachet.kalah.controller.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import tbrachet.kalah.controller.KalahController;
import tbrachet.kalah.controller.KalahForm;


public class KalahControllerTest {

	private KalahController controller;

	private KalahForm form;

	@Before
	public void init() {
		controller = new KalahController();
	}
	
	/**
	 * Test the init of a new game 
	 */
	@Test
	public void newGameTest() {

		int pits[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 0;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		
		
		controller.newGame(form, null, new ModelMap());
		
		int pitsExpected[] = { 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };
		int currentPlayerExpected = 1;
		int victoryExpected = 0;
		int pitPlayedExpected = -1;

		// assert statements
		assertEquals(currentPlayerExpected, form.getCurrentPlayer());
		assertEquals(victoryExpected, form.getVictory());
		assertEquals(pitPlayedExpected, form.getPitPlayed());
		assertEquals(pitsExpected[0], form.getPits()[0]);
		assertEquals(pitsExpected[1], form.getPits()[1]);
		assertEquals(pitsExpected[2], form.getPits()[2]);
		assertEquals(pitsExpected[3], form.getPits()[3]);
		assertEquals(pitsExpected[4], form.getPits()[4]);
		assertEquals(pitsExpected[5], form.getPits()[5]);
		assertEquals(pitsExpected[6], form.getPits()[6]);
		assertEquals(pitsExpected[7], form.getPits()[7]);
		assertEquals(pitsExpected[8], form.getPits()[8]);
		assertEquals(pitsExpected[9], form.getPits()[9]);
		assertEquals(pitsExpected[10], form.getPits()[10]);
		assertEquals(pitsExpected[11], form.getPits()[11]);
		assertEquals(pitsExpected[12], form.getPits()[12]);
		assertEquals(pitsExpected[13], form.getPits()[13]);

	}

	/**
	 * Test if when the player 1 ends up in a pit with no specific rules, it's player 2 turn to play
	 */
	@Test
	public void player1toPlayer2Test() {

		int pits[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 0;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(2, form.getCurrentPlayer());
		assertEquals(0, form.getVictory());

	}
	
	/**
	 * Test if when the player 2 ends up in a pit with no specific rules, it's player 1 turn to play
	 */
	@Test
	public void lastStoneOwnPitPlayer2Test() {

		int pits[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0 };
		int currentPlayer = 2;
		int victory = 0;
		int pitPlayed = 7;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(1, form.getCurrentPlayer());
		assertEquals(0, form.getVictory());
	}
	
	/**
	 * Test if when the player 1 ends up in his own kalah, he should play again
	 */
	@Test
	public void lastStoneOwnKalahPlayer1Test() {

		int pits[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 5;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(1, form.getCurrentPlayer());
		assertEquals(0, form.getVictory());
	}
	
	/**
	 * Test if when the player 2 ends up in his own kalah, he should play again
	 */
	@Test
	public void lastStoneOwnKalahPlayer2Test() {

		int pits[] = { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0 };
		int currentPlayer = 2;
		int victory = 0;
		int pitPlayed = 12;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(2, form.getCurrentPlayer());
		assertEquals(0, form.getVictory());
	}
	
	/**
	 * Test if when the player 1 ends up in one of his empty pits, he puts this stone
	 * in his Kalah and captures the opposit pit
	 */
	@Test
	public void player1CapturesPlayer2StonesTest() {

		int pits[] = { 1, 2, 1, 0, 1, 1, 0, 1, 1, 5, 0, 0, 1, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 1;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(6, form.getPits()[6]);
		assertEquals(0, form.getVictory());
	}
	
	/**
	 * Test if when the player 2 ends up in one of his empty pits, he puts this stone
	 * in his Kalah and captures the opposit pit
	 */
	@Test
	public void player2CapturesPlayer1StonesTest() {

		int pits[] = { 1, 2, 1, 4, 1, 1, 0, 2, 1, 0, 0, 0, 1, 0 };
		int currentPlayer = 2;
		int victory = 0;
		int pitPlayed = 7;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(5, form.getPits()[13]);
		assertEquals(0, form.getVictory());
	}
	
	/**
	 * Test if player 1 wins if all of player 1 s pits are empty 
	 */
	@Test
	public void player1WinsTest() {

		int pits[] = { 0, 0, 0, 0, 0, 2, 99, 2, 1, 0, 0, 0, 1, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 5;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(1, form.getVictory());
	}
	
	/**
	 * Test if player 2 wins if all of player 1 s pits are empty 
	 */
	@Test
	public void player2WinsTest() {

		int pits[] = { 0, 0, 0, 0, 0, 2, 0, 2, 1, 0, 0, 0, 1, 99 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = 5;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
		Method method;
		try {
			method = KalahController.class.getDeclaredMethod("play", KalahForm.class);
			method.setAccessible(true);
			method.invoke(controller, form);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// assert statements
		assertEquals(2, form.getVictory());
	}

}

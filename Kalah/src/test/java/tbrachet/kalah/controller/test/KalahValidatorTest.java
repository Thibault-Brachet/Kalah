package tbrachet.kalah.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;

import tbrachet.kalah.controller.KalahForm;
import tbrachet.kalah.controller.KalahValidator;


public class KalahValidatorTest {

	private KalahValidator kalahValidator;

	private KalahForm form;
	
	private BindException errors; 
	
	@Before
	public void init() {
		kalahValidator = new KalahValidator();
		
		int pits[] = { 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };
		int currentPlayer = 1;
		int victory = 0;
		int pitPlayed = -1;

		form = new KalahForm(pits, currentPlayer, victory, pitPlayed);
	}
	
	/**
	 * Test the validation of the form with the good number of stones in play 
	 */
	@Test
	public void correctNumberOfStonesInPlayTest() {

		int pitPlayed = 0;
		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(0, errors.getFieldErrorCount("pits"));
		
		
	}

	/**
	 * Test the non validation of the form with a incorrect number of stones in play
	 */
	@Test
	public void incorrectNumberOfStonesInPlayTest() {
		
		int pitPlayed = 0;
		form.setPitPlayed(pitPlayed);

		int pits[] = { 99, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };

		form.setPits(pits);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pits"));
		
		
	}	
	
	/**
	 * Test the  validation of the form with a correct pit played by player 1
	 */
	@Test
	public void correctPitPlayedByPlayer1Test() {

		int pitPlayed = 0;

		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(0, errors.getFieldErrorCount("pitPlayed"));
		
		
	}	
	
	/**
	 * Test the  validation of the form with a correct pit played by player 1
	 */
	@Test
	public void opponentsPitPlayedByPlayer1Test() {

		int pitPlayed = 9;

		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}	
	
	/**
	 * Test the  validation of the form with a correct pit played by player 2
	 */
	@Test
	public void correctPitPlayedByPlayer2Test() {

		int currentPlayer = 2;
		int pitPlayed = 7;

		form.setCurrentPlayer(currentPlayer);
		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(0, errors.getFieldErrorCount("pitPlayed"));
		
		
	}	
	
	/**
	 * Test the  validation of the form with a correct pit played by player 2
	 */
	@Test
	public void opponentsPitPlayedByPlayer2Test() {
		
		int currentPlayer = 2;
		int pitPlayed = 2;

		form.setCurrentPlayer(currentPlayer);
		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}	
	
	/**
	 * Test the  non validation of the form with player 1 playing his kalah
	 */
	@Test
	public void kalahPitPlayedByPlayer1Test() {
		
		int pitPlayed = 6;

		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}
	
	/**
	 * Test the  non validation of the form with player 2 playing his kalah
	 */
	@Test
	public void kalahPitPlayedByPlayer2Test() {
		
		int currentPlayer = 2;
		int pitPlayed = 13;

		form.setCurrentPlayer(currentPlayer);
		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}
	
	/**
	 * Test the  non validation of the form with player 1 playing an empty pit
	 */
	@Test
	public void emptyPitPlayedByPlayer1Test() {
		
		int pitPlayed = 0;
		int pits[] = { 0, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };

		form.setPits(pits);
		form.setPitPlayed(pitPlayed);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}
	
	/**
	 * Test the  non validation of the form with player 2 playing his kalah
	 */
	@Test
	public void emptyPitPlayedByPlayer2Test() {
		
		int currentPlayer = 2;
		int pitPlayed = 7;
		int pits[] = { 0, 6, 6, 6, 6, 6, 0, 0, 6, 6, 6, 6, 6, 0 };

		form.setCurrentPlayer(currentPlayer);
		form.setPitPlayed(pitPlayed);
		form.setPits(pits);
		
		errors = new BindException(form, "form");
		
		kalahValidator.validate(form, errors);
		
		assertEquals(1, errors.getFieldErrorCount("pitPlayed"));
		
		
	}

}

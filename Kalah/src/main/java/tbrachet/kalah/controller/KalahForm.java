package tbrachet.kalah.controller;

public class KalahForm {

	private int pits[] = new int[14];

	private int currentPlayer = 1;

	private int victory = 0;

	private int pitPlayed = -1;

	public KalahForm() {
		super();
		reset();
	}
	
	public void reset(){
		pits[0] = 6;
		pits[1] = 6;
		pits[2] = 6;
		pits[3] = 6;
		pits[4] = 6;
		pits[5] = 6;
		pits[6] = 0;
		pits[7] = 6;
		pits[8] = 6;
		pits[9] = 6;
		pits[10] = 6;
		pits[11] = 6;
		pits[12] = 6;
		pits[13] = 0;		
	}

	public int[] getPits() {
		return pits;
	}

	public void setPits(int[] pits) {
		this.pits = pits;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}

	public int getPitPlayed() {
		return pitPlayed;
	}

	public void setPitPlayed(int pitPlayed) {
		this.pitPlayed = pitPlayed;
	}

}

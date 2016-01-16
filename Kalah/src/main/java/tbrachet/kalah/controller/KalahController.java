package tbrachet.kalah.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KalahController {
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new KalahValidator());
    }

	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public String action(@Valid @ModelAttribute(value = "kalah") final KalahForm pKalah,
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {
			play(pKalah);
		}
		return "game";
	}

	@RequestMapping(value = "/newGame", method = RequestMethod.GET)
	public String newGame(@ModelAttribute(value = "kalah") final KalahForm pKalah, final BindingResult pBindingResult,
			final ModelMap pModel) {

		pKalah.reset();
		
		pModel.addAttribute("kalah", pKalah);

		return "game";
	}

	private void play(KalahForm form) {
		
		int pits[] = form.getPits();
		int player = form.getCurrentPlayer();
		int pitIndex = form.getPitPlayed();
//		int victory = form.getVictory();

		// Initialisation
		int nbStonesInSelPit = -1;
		int nbGap = 0;
		int tempPitIndex = pitIndex;

		// player 1 playing

		// we don't need to verify if the player selected an authorized pit
		// it's done in the validate method of the form
		nbStonesInSelPit = pits[pitIndex];

		// We first empty the pit selected
		pits[pitIndex] = 0;

		for (int i = 1; i < nbStonesInSelPit ; i++) {
			tempPitIndex = (pitIndex + i + nbGap) % 14;

			if (player == 1) {
				// if player1 is playing, we can't add a stone in player2 Kalah
				if (tempPitIndex == 13) {
					nbGap += 1;
					tempPitIndex = 0;
				}
			} else {
				// if player2 is playing, we can't add a stone in player1 Kalah
				if (tempPitIndex == 6) {
					nbGap += 1;
					tempPitIndex = 7;
				}
			}
			// We add one stone in each of the (nbStonesInSelPit-1) coming pits
			// The %14 allow to come back at the first position
			pits[tempPitIndex] += 1;
		}

		// Case of the last stone
		tempPitIndex = (tempPitIndex + 1) % 14;

		if (player == 1) {
			if (tempPitIndex == 6) {
				// TODO Handle the "play again" event for player 1
				form.setCurrentPlayer(1);
				pits[tempPitIndex] += 1;
			} else {				
				form.setCurrentPlayer(2);			
				if (tempPitIndex == 13) {
					// if player1 is playing, we can't add a stone in player2
					// Kalah
					tempPitIndex = 0;
				}

				if (pits[tempPitIndex] == 0 && 0 <= tempPitIndex && tempPitIndex < 6) {
					// if the last stone end up on an empty pit
					// the player put this stone the stones on the opposite pit
					// in his kalah
					pits[6] += 1;
					pits[6] += pits[12 - tempPitIndex];
					pits[12 - tempPitIndex] = 0;
				} else {
					pits[tempPitIndex] += 1;
				}

			}
			// if the last stone end up in his own Kalah, he will play the next
			// turn
		} else {
			if (tempPitIndex == 13) {
				// TODO Handle the "play again" event
//				player = 2;
				form.setCurrentPlayer(2);
				pits[tempPitIndex] += 1;
			} else {
//				player = 1;
				form.setCurrentPlayer(1);
				if (tempPitIndex == 6) {
					// if player2 is playing, we can't add a stone in player1
					// Kalah
					tempPitIndex = 7;
				}
				if (pits[tempPitIndex] == 0 && 7 <= tempPitIndex && tempPitIndex < 13) {
					// if the last stone end up on an empty pit
					// the player put this stone the stones on the opposite pit
					// in his kalah
					pits[13] += 1;
					pits[13] += pits[12 - tempPitIndex];
					pits[12 - tempPitIndex] = 0;
				} else {
					pits[tempPitIndex] += 1;
				}

			}
		}

		// TODO Handle the end of the game if there are no more stones on the
		// players pit
		if (player == 1) {
			if (pits[0] == 0 && pits[1] == 0 && pits[2] == 0 && pits[3] == 0 && pits[4] == 0 && pits[5] == 0) {
				// if all the player's pit are empty, this is the end of the
				// game
				// all remaining stones in the opponent's pits are put in his
				// kalah
				pits[13] = pits[13] + pits[7] + pits[8] + pits[9] + pits[10] + pits[11] + pits[12];
				pits[12] = 0;
				pits[11] = 0;
				pits[10] = 0;
				pits[9] = 0;
				pits[8] = 0;
				pits[7] = 0;

				if (pits[6] > pits[13]) {
					form.setCurrentPlayer(0);
					form.setVictory(1);
				} else {
					form.setCurrentPlayer(0);
					form.setVictory(2);
				}
			}
		} else {
			if (pits[7] == 0 && pits[8] == 0 && pits[9] == 0 && pits[10] == 0 && pits[11] == 0 && pits[12] == 0) {
				// if all the player's pit are empty, this is the end of the
				// game
				// all remaining stones in the opponent's pits are put in his
				// kalah
				pits[6] = pits[6] + pits[0] + pits[1] + pits[2] + pits[3] + pits[4] + pits[5];
				pits[5] = 0;
				pits[4] = 0;
				pits[3] = 0;
				pits[2] = 0;
				pits[1] = 0;
				pits[0] = 0;

				if (pits[6] > pits[13]) {
					form.setCurrentPlayer(0);
					form.setVictory(1);
				} else {
					form.setCurrentPlayer(0);
					form.setVictory(2);
				}
			}
		}

	}

}
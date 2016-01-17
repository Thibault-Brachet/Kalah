package tbrachet.kalah.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class KalahValidator implements Validator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class cl) {
		return KalahForm.class.isAssignableFrom(cl);

	}

	public void validate(Object ob, Errors errors) {
		KalahForm form = (KalahForm) ob;

		if(form !=null){
			if (form.getPitPlayed() >= 0) {
				// first, we have to verify that the player played one of his pit
				if (form.getCurrentPlayer() == 1) {
					if (form.getPitPlayed() > 6) {
						errors.rejectValue("pitPlayed", "error.opponents.pit");
					} else if(form.getPitPlayed() == 6){
						errors.rejectValue("pitPlayed", "error.kalah.pit");
					}
					else {
						// if the player selects an empty pit among his pits
						if (form.getPits()[form.getPitPlayed()] == 0) {
							errors.rejectValue("pitPlayed", "error.empty.pit");
						}
					}
				} else {
					if (form.getPitPlayed() < 7) {
						errors.rejectValue("pitPlayed", "error.opponents.pit");
					}
					else if (form.getPitPlayed() == 13){
						errors.rejectValue("pitPlayed", "error.kalah.pit");
					}
					else {
						// if the player selects an empty pit among his pits
						if (form.getPits()[form.getPitPlayed()] == 0) {
							errors.rejectValue("pitPlayed", "error.empty.pit");
						}
					}
				}
				
				if(form.getPits() != null){
					// the number of the stones in play should be 72 all the time
					int stonesInPlay = sum(form.getPits());
					if(stonesInPlay != 72){
						errors.rejectValue("pits", "error.empty.pit");
					}
				}
				
			}
			
		}

	}

	private int sum(int[] pits) {
		int sum = 0;
		for (int i = 0; i < pits.length; i++) {
			sum += pits[i];
		}
		return sum;
	}

}

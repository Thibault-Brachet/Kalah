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

		if (form.getPitPlayed() >= 0) {
			// first, we have to verify that the player played one of his pit
			if (form.getCurrentPlayer() == 1) {
				if (form.getPitPlayed() > 5) {
					errors.rejectValue("pitPlayed", "error.opponents.pit");
				} else {
					// if the player selects an empty pit among his pits
					if (form.getPits()[form.getPitPlayed()] == 0) {
						errors.rejectValue("pitPlayed", "error.empty.pit");
					}
				}
			} else {
				if (form.getPitPlayed() == 13 || form.getPitPlayed() < 7) {
					errors.rejectValue("pitPlayed", "error.opponents.pit");
				} else {
					// if the player selects an empty pit among his pits
					if (form.getPits()[form.getPitPlayed()] == 0) {
						errors.rejectValue("pitPlayed", "error.empty.pit");
					}
				}
			}

		}

	}

}

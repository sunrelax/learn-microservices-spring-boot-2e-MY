package microservices.book.multiplication.challenge;

import org.springframework.stereotype.Service;

import microservices.book.multiplication.user.User;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	@Override
	public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
		int result = attemptDTO.getFactorA() * attemptDTO.getFactorB();
		boolean isCorrect = result == attemptDTO.getGuess() ? true : false;
		User user = new User(null, attemptDTO.getUserAlias());
		ChallengeAttempt challengeAttempt = new ChallengeAttempt(1, user, attemptDTO.getFactorA(),
				attemptDTO.getFactorB(), attemptDTO.getGuess(), isCorrect);
		return challengeAttempt;
	}
}

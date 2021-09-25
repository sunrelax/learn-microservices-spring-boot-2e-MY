package microservices.book.multiplication.challenge;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeAttemptController.class)
@ComponentScan(basePackages = "microservices.book.multiplication")
public class ChallengeServiceTest {

	private ChallengeService challengeService;

	@BeforeEach
	public void setUp() {
		challengeService = new ChallengeServiceImpl();
	}

	@Test
	public void checkCorrectAttemptTest() {
// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
// then
		then(resultAttempt.isCorrect()).isTrue();
	}

	@Test
	public void checkWrongAttemptTest() {
// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 5000);

// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
// then
		then(resultAttempt.isCorrect()).isFalse();
	}
}
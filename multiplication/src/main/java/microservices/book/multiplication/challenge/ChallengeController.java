package microservices.book.multiplication.challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/challenges")
class ChallengeController {

	private final ChallengeGeneratorService challengeGeneratorService;

	@GetMapping("/random")
	Challenge getRandomChallenge() {
		Challenge challenge = challengeGeneratorService.randomChallenge();
		log.info("Generating a random challenge: {}", challenge);
		return challenge;
	}
}
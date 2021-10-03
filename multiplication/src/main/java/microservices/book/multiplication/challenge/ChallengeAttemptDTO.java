package microservices.book.multiplication.challenge;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

/**
 * Attempt coming from the user
 */
@AllArgsConstructor
@Getter
@Builder
@JsonDeserialize(builder = ChallengeAttemptDTO.ChallengeAttemptDTOBuilder.class)
@Value
public class ChallengeAttemptDTO {
	@Min(1)
	@Max(99)
	int factorA, factorB;
	@NotBlank
	String userAlias;
	@Positive(message = "How could you possibly get a negative result here? Try again.")
	int guess;

}
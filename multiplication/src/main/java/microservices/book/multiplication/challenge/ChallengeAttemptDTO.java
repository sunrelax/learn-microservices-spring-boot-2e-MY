package microservices.book.multiplication.challenge;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class ChallengeAttemptDTO {
	@Min(1)
	@Max(99)
	@JsonProperty("factorA")
	int factorA;
	@Min(1)
	@Max(99)	
	@JsonProperty("factorB")
	int factorB;
	@NotBlank
	@JsonProperty("userAlias")
	String userAlias;
	@Positive(message = "How could you possibly get a negative result here? Try again.")
	@JsonProperty("guess")
	int guess;

}

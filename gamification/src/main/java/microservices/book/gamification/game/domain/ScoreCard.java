package microservices.book.gamification.game.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents the Score linked to an attempt in the game, with an
 * associated user and the timestamp in which the score is registered.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCard {

	// The default score assigned to this card, if not specified.
	public static final int DEFAULT_SCORE = 10;

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private String cardId;
	
    private String userId;
	private String attemptId;
	@EqualsAndHashCode.Exclude
	private long scoreTimestamp;
	private int score;

	public ScoreCard(final String userId, final String attemptId) {
		this(null, userId, attemptId, System.currentTimeMillis(), DEFAULT_SCORE);
	}

}

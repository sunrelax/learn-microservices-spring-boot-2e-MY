package microservices.book.gamification.game.domain;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * This class links a Badge to a User. Contains also a timestamp with the moment in which the user got it.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeCard {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
    private String badgeId;

    private String userId;
    @EqualsAndHashCode.Exclude
    private long badgeTimestamp;
    private BadgeType badgeType;

    public BadgeCard(final String userId, final BadgeType badgeType) {
        this(null, userId, System.currentTimeMillis(), badgeType);
    }

}

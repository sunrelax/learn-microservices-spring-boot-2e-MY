package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.game.domain.BadgeType;
import microservices.book.gamification.game.domain.ScoreCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class FirstWonBadgeProcessorTest {

    private FirstWonBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new FirstWonBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfFirstTime() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10,
                        List.of(new ScoreCard(UUID.randomUUID().toString(), UUID.randomUUID().toString())),
                        null);
        assertThat(badgeType).contains(BadgeType.FIRST_WON);
    }

    @Test
    public void shouldNotGiveBadgeIfNotFirstTime() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(20,
                        List.of(new ScoreCard(UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                                new ScoreCard(UUID.randomUUID().toString(), UUID.randomUUID().toString())),
                        null);
        assertThat(badgeType).isEmpty();
    }
}
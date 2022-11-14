package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.challenge.ChallengeSolvedEvent;
import microservices.book.gamification.game.domain.BadgeType;
import microservices.book.gamification.game.domain.ScoreCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class LuckyNumberBadgeProcessorTest {

    private LuckyNumberBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new LuckyNumberBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfLuckyFactor() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10,
                        List.of(new ScoreCard(UUID.randomUUID().toString(), UUID.randomUUID().toString())),
                        new ChallengeSolvedEvent(UUID.randomUUID().toString(), true, 42, 10, UUID.randomUUID().toString(), "John"));
        assertThat(badgeType).contains(BadgeType.LUCKY_NUMBER);
    }

    @Test
    public void shouldNotGiveBadgeIfNotLuckyFactor() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10,
                        List.of(new ScoreCard(UUID.randomUUID().toString(), UUID.randomUUID().toString())),
                        new ChallengeSolvedEvent(UUID.randomUUID().toString(), true, 43, 10, UUID.randomUUID().toString(), "John"));
        assertThat(badgeType).isEmpty();
    }
}

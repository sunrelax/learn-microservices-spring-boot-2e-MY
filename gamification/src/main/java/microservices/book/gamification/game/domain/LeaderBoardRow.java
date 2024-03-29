package microservices.book.gamification.game.domain;

import lombok.*;

import java.util.List;

/**
 * Represents a line in our Leaderboard.
 */
@Value
@AllArgsConstructor
public class LeaderBoardRow {

    String userId;
    Long totalScore;
    @With
    List<String> badges;

    public LeaderBoardRow(final String userId, final Long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.badges = List.of();
    }

}

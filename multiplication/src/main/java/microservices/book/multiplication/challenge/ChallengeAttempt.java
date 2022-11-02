package microservices.book.multiplication.challenge;

import lombok.*;
import microservices.book.multiplication.user.Users;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Identifies the attempt from a {@link Users} to solve a challenge.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private String id;
//    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users user;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}

package microservices.book.multiplication.user;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Stores information to identify the user.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false)
	private String id;
    
//    private Long id;
    private String alias;

    public Users(final String userAlias) {
        this(null, userAlias);
    }
}

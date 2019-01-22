package ge.unknown.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by MJaniko on 10/26/2016.
 */
@Entity
@Table(name = "qr_user")
@Getter
@Setter
//@Builder
public class User extends AbstractEntity {

    @ManyToMany
    @JoinTable(name = "qr_user_role",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> role;

    @NotEmpty
    @Size(min = 3, max = 20)
    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Size(min = 8, max = 64)
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "is_active", columnDefinition = "bit(1) DEFAULT 1")
    private boolean active = true;

    public User() {
    }

    public User(User user) {
        this.role = user.role;
        this.username = user.username;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.active = user.active;
        this.dateCreated = user.dateCreated;
        this.dateUpdated = user.dateUpdated;
    }
}
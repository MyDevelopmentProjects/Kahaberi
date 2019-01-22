package ge.unknown.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "qr_role")
@Getter
@Setter
@Builder
public class Role extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @ManyToMany
    @JoinTable(name = "qr_role_permission",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    private List<Permission> permissions;
}
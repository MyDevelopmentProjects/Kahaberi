package ge.unknown.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "qr_permission")
@Getter
@Setter
@Builder
public class Permission extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
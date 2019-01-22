package ge.unknown.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 3/18/18.
 */
@Entity
@Table(name = "qr_language")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Language extends AbstractEntity {

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "description")
    private String description;

}
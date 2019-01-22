package ge.unknown.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by user on 4/29/18.
 */

@Entity
@Table(name = "qr_exception")
@Getter
@Setter
public class Exception extends AbstractEntity {

    @Lob
    @Column(name = "body")
    private String body;

    @Lob
    @Column(name = "stack_trace")
    private String stackTrace;

    @Lob
    @Column(name = "canonical_name")
    private String getCanonicalName;

}

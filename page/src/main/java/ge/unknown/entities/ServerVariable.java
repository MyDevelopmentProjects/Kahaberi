package ge.unknown.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "qr_server_variable")
@Getter
@Setter
@Builder
public class ServerVariable extends AbstractEntity {

    @Column(name = "server_key", unique = true)
    private String serverKey;

    @Column(name = "server_val")
    private String serverVal;
}
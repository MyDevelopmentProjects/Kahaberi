package ge.unknown.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "qr_city")
@Getter
@Setter
public class City extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="city")
    private Set<CityLocale> locale;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    private Integer SRID;

    private String shortName;

    private String shortCodeId;
}


package ge.unknown.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MJaniko on 3/8/2017.
 */
@Entity
@Table(name = "qr_country")
@Getter
@Setter
public class Country extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="country")
    private Set<CountryLocale> locale;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

}


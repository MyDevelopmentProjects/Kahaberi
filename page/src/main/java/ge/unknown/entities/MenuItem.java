package ge.unknown.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by user on 4/14/18.
 */
@Entity
@Table(name = "qr_menu_item")
@Getter
@Setter
public class MenuItem extends AbstractEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="item")
    private Set<MenuItemLocale> locale = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="item")
    private Set<MenuItemSQ> sq = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MenuCategory category;

    @Column(name = "price")
    private double price;

    @Column(name = "images")
    private String images;

}

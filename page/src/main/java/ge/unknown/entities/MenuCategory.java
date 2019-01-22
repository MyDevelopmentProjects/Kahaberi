package ge.unknown.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by user on 4/14/18.
 */
@Entity
@Table(name = "qr_menu_category")
@Getter
@Setter
public class MenuCategory extends AbstractEntity{

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="category")
    private Set<MenuCategoryLocale> locale;


}

package ge.unknown.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by user on 4/14/18.
 */
@Entity
@Table(name = "qr_menu_item_locale")
@Getter
@Setter
public class MenuItemLocale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lang_id")
    private Language lang;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private MenuItem item;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

}

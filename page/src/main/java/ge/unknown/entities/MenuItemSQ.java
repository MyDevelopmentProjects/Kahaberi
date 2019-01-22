package ge.unknown.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 4/14/18.
 */
@Entity
@Table(name = "qr_menu_item_sq")
@Getter
@Setter
public class MenuItemSQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private MenuItem item;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private int quantity;

}

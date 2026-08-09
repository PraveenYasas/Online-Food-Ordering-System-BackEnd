package lk.ijse.cmjd113.FoodOrderingSystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_items")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FoodItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // @JoinColumn(name = "category_id", nullable = false)
                                                        // mekan thamai data base ekata kiyanne ara categories table ekath ekka sambanda wenna me table eka athule Foreign Key Column ekak hadanna kiyala.
                                                        // ee column eke nama category_id wenna ona,
                                                        // nullable = false dala thiyana nisa system ekata dana hama kaamakma aniwaryayenma mokak hari category ekakata aithi wenna ona.

    private CategoryEntity category;    // meken thamai java code eka athule adala kama ekai category ekai link karanne.
                                        // me kaama ekama aithiwena mulu category object ekama me asse save karagena thiyaganna puluwan.

    @Column(name = "image_url")
    private String imageUrl; // meka thamai food item ekata adala image eka database ekata save karanna ona nam meka use karanne.

    // hama kaamakma mokak hari kadayakata aithi wenna ona nisa meka use karanne. mekath meka database ekata save karanna ona nam meka use karanne.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;
}

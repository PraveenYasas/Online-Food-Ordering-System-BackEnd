package lk.ijse.cmjd113.FoodOrderingSystem.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String address;
    
    private String contactNumber;
    
    private String imageUrl;

    @JsonIgnore 
    @OneToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @JsonIgnore 
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<FoodItemEntity> foodItems;
}
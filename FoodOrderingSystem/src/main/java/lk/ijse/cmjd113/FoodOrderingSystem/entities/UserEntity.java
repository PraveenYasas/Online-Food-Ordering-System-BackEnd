package lk.ijse.cmjd113.FoodOrderingSystem.entities;

// Entity folder eka athule thiyenne database eke hadena tables walata adala java classes witharai.
// User kiyanne databse table ekak misak sicurity code ekak nemei.

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")  // database eke hadena table eke nama.
@Data                   // Lombokwalink automatically getters, settes, toString hadala denawa.
@NoArgsConstructor      // default constructor eka hadala denawa.
@AllArgsConstructor     // Okoma fields thiyana constructor ekak hadala denawa.

public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id eka auto increment karanna.
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;               // Email eka aniwaryai, duplicate email ekak database eke save karanna ba.

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)        // Hadagaththa enum eka pawichchi karanawa
    // meka damme nah nam data bse eke save wenne CUSTOMER wenuwata 0, ADMIN wenuwata 1, RESTAURANT_OWNER wenuwata 2 widihata. 
    // Habai meka damme nisa database eke save wenne "CUSTOMER", "ADMIN", "RESTAURANT_OWNER" widihata.
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist                         // mekne wenne database ekata data save wenna thathparekata kalin dan thiyana welawa ibema setwena eka thamai.
    protected void onCreate() {
        createdAt = LocalDateTime.now();  // User ekak hadaddi createdAt field eka automatic now() value ekak set karanna.
    }
}

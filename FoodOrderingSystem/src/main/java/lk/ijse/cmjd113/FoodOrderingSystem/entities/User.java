package lk.ijse.cmjd113.FoodOrderingSystem.entities;

import java.time.LocalDateTime;

import javax.management.relation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")  // database eke hadena table eke nama.
@Data                   // Lombokwalink automatically getters, settes, toString hadala denawa.
@NoArgsConstructor      // default constructor eka hadala denawa.
@AllArgsConstructor     // Okoma fields thiyana constructor ekak hadala denawa.

public class User {
    
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

    @Enumerated(EnumType.STRING)        // Hadagaththa e num eka pawichchi karanawa
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist                         // mekne wenne database ekata data save wenna thathparekata kalin dan thiyana welawa ibema setwena eka thamai.
    protected void onCreate() {
        createdAt = LocalDateTime.now();  // User ekak hadaddi createdAt field eka automatic now() value ekak set karanna.
    }
}

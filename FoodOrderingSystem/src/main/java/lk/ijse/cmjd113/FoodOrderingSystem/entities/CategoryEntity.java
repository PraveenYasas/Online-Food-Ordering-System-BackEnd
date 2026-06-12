package lk.ijse.cmjd113.FoodOrderingSystem.entities;

// me class eken karanne ape Database eke categories kiyala table ekak hadanna spring boot ekata upades dena ekathama.

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                         // me @Entity - meken springboot ekata kiyanne 
                                // meka samayaya java class ekek nemei, meka data bse eke table ekak widihata aduraganna kiyala.

@Table(name = "categories")     // @Table(name = "categories")
                                // Database eke hadena Table eke nama aniwaryayen categorios wenna ona kiyala niyama karanawa.
                                // meka nodammanam database table eke nama hadenne class eke nama widihatama "category_entity" widihata.

@Data                           // @Data
                                // meka api dapu lombok eke supirima wadak.
                                // meka dammahama api liwwa method eke getters, setters, toString() method liyanna one naha.
                                // ee okkoma code eke compile weddima ibe hadenawa.
                                // code eka pattama clean wenawa.

@NoArgsConstructor              // @NoArgsConstructor
                                // meka dammahama default constructor ekak hadala denawa. parameters nathi ekak.
                            
@AllArgsConstructor             // @AllArgsConstructor
                                // meka dammahama okoma fields thiyana constructor ekak hadala denawa. parameters thiyana ekak.
                                // oya ude anotation dekama wenne lombok walin.

public class CategoryEntity {
    @Id                                                             // meken kiyanne ilagata thiyana variable eka thama me table eke pradhanama yathura kiyala.
                                                                    // E kiyanne primary key ekak kiyala.
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // meken kiyane ee primary key eka api athin denna one naha, 1,2,3 widihata auto increment wena widihata hadanna kiyala.

    private Long id;    // Id eka save wena variable eka.
                        // meke int wenuwata long pawichchi kale records laksha ganak aawoth ida madiwenne nathi wenna.

    @Column(nullable = false, unique = true)                        // meke iilagata thiyana name kiyana ekata nithi dekak thiyanawa.
                                                                    // Category ekata aniwa namak thiyenna ona. His wa thiyanna baha.
                                                                    // Ekama nama thiyana categories dekak hadanna baha. (Dublicate unoth error ekak enawa.)

    private String name;// Category eke nama save karaganna thana.

    private String description;     // Category eke description eka save karaganna thana.

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)    // mekathama wenath table ekak ekka thiyana sambandaya
                                                                    // @OneToMany               - meken kiyane eka categoory ekak yatathe kama jathi godak thiyenne puluwan kiyana ekai.
                                                                    // mappedBy = "category"    - meken kiyanne mesambandaye palanaya karanne anithpaththe thiyana category kiyana variable eken kiyana ekai.
                                                                                            //  - e nisa table eka athule aluthen forign key column ekak hadanna epa kiyala niyama karanawa.
                                                                    // cascade = CascadeType.ALL- meka maara neethiyak.
                                                                                            //  - meken kiyanne api category eka makala dammoth ekata aithi kama okkoma ibema database eke makila yanna ona kiyala.
                                                                    
    private List<FoodItemEntity> foodItems;     // private List<FoodItemEntity> foodItems; - eka category ekakata kama jathi godak thiyana nisa e kama jathi okkoma eka thanaka thiyaganna list ekak widihata meka hadala thiyanawa.

}

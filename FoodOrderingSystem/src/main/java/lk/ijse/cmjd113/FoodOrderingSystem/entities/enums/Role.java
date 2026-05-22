package lk.ijse.cmjd113.FoodOrderingSystem.entities.enums;

// meke enum type ekakin thiyaganne ape sysytem eke arakshawata.

//      waradi type kireem nawathwanna
//      - api users lage role eka ikama string widihata haduwanam kauru hari "CUSTOMER" wenuwata "CUSTMER" kiyala hari simple walin hari type karanna puluwan. Ehema unoth system ekama iwarai.
//      - habai enum type ekakin haduwahama apita pawichchi karanna puluuwan eka athule liyala thiyana CUSTOMER, ADMIN, RESTAURANT_OWNER kiyana ewwa witharai.

// Database ekata kiyawanna lesi karanawa
//      - Godak welawata database eke me wage dewal save karaganne 0, 1 widihata.
//      - Habai api ara User.java eke @Enumerated(EnumType.STRING) kiyala dapu nisa databse eka baluwahama "CUSTOMER", "ADMIN", "RESTAURANT_OWNER" kiyala thiyana dewal save karaganne. 


// issarahata spring security walata mara lesii

//      - Issarahara app eke logins / tokens hadaddi apita lesiyen condition danna puluwan 
//      - aluth kama jathiyak add karana API ekakata yanna puluwan Role.ADMIN kenekta witharai. Samanyaya CUSTOMER kenek karanna haduwoth error ekak denna puluwan.

// Hariyata kiwwoth Role.java kiyanne ape system eke inna users lawa hariyata warga karala aduraganna dunna VIP pass ekak wage.

public enum Role {
    CUSTOMER,
    ADMIN,
    RESTURANT_OWNER
}

// aii api me enummtype eka entities athule thiyagena eka athule pakage ekak hadala eke damme

// DTO (Data Transfer Object) kiyanne eka pawichchi karanne React ekai Springboot ekaii athare data pass karanna
// Habai role kiyanne ape dtabase eke thiyana ser entity ekata kelinma sambanda wena pradhana (Crore) data ekak.
// Software enginering Best practices anuwa entity ekak kawadawath DTO ekak matha yapena ba. 
// Role eka DTO pakage eka athue dammoth User Entity ekata wenawa import karaganna.
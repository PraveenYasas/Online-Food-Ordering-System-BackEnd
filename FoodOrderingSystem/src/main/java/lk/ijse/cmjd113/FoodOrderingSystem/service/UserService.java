package lk.ijse.cmjd113.FoodOrderingSystem.service;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;

// meken karanne monawada karanna ona kiyana interface eka hadana eka.

public interface UserService {

    // // 1. meka samanyayen karannne naha.

    // //    meka kalahama wenne frontend eken ena data kelinma UserEntity ekata allagena eka kelinma database eke save wenawa.

    // // meke thiyana awula thamai UserEntity eka hariyata ape data base eke kadapathak wage.
    // // eke database eke thiyana hama column ekakma thiyanawa.
    // // api eka kelinma eliyata expose kalahama, hacker kenekta hari pita kenekta hari ape database eke structure eka balaganna puluwan.

    // UserEntity saveUser(UserEntity user);     // me method eka damme user ekak database eke save karanna.

    // 2. meka samanyayen kramayayen karana karamaya.

    // Mekedi karanne samanyayen DTO pawichchi karala.
    // aluthen UserDTO kiyala ekak haduwa. Eka nikan hariyata pearanayak athara madiyek wage nikan.
    // Dan frontend eken kelinma data ewanne me DTO ekata.
    // Itapasse service layer ekedi api e DTO eke thiyana data aragena alith userEntity ekak athulata dala (Map karala) Database ekata ywanawa.

    // Me kramayen labena wasi 3k thiyanawa

    // Uparima arakshawa 
    // - Hithuwoth mehema issarahata api UserTable eke failedLoginAttempts (Waradiyata fields Login) gahapu wara ganana wage rahasigatha columna ekak thiyanawa kiyala.
    // - Api DTO eka athulata e field eka noda idiyama, Frontend eken kauruhari hacker kenek eka aluthen ewwoth ape system eka eeka baraganne naha.
    // - Database eke ewwa eliyata leak wenneth naha.
    
    // Amathara Data hasiraweema
    // - Hithannako apita SignUp weddi password saha confiremPassword kiyala fields dekak thiyenawa kiyala.
    // - Ape data bse eke confiremPassword kiyala ekak save karane naha. 
    // - Habai aluth krameta apita UserDTO eka athulata confirmPassword eka dala Service Layer ekedi edeke samanada kiyala check karanawa.
    // - Itapasse harinam witharak Password eka Etity ekakata dala Database eke save karanna puluwan.
    // - Kalin kramayata meka karanna baha.

    // Wenaskam walata Oroththu deema
    // - Hithuwoth mehema, Issarahata column ekaka name ekak firstName indan f_name walata wenas karanna una kiyala.
    // - parana kramayatanam ape mulu frontend code ekama wenas karanna wenawa. 
    // - Habai aluth kramayata frontend eke digatam DTO eke thiyana firstName ma pawichchi karanawa.
    // - "entity.setF_name(dto.getFirstName())" kiyala code eka poddak wenas karanna witharai thiyenne.
    // - Anith kisi dekata haniyak wenne naha.
}

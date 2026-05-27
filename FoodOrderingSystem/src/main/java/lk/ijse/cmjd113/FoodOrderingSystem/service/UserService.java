package lk.ijse.cmjd113.FoodOrderingSystem.service;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;

// meken karanne monawada karanna ona kiyana interface eka hadana eka.

public interface UserService {

    // 1. meka samanyayen karannne naha.

    //    meka kalahama wenne frontend eken ena data kelinma UserEntity ekata allagena eka kelinma database eke save wenawa.

    // meke thiyana awula thamai UserEntity eka hariyata ape data base eke kadapathak wage.
    // eke database eke thiyana hama column ekakma thiyanawa.
    // api eka kelinma eliyata expose kalahama, hacker kenekta hari pita kenekta hari ape database eke structure eka balaganna puluwan.

    UserEntity saveUser(UserEntity user);     // me method eka damme user ekak database eke save karanna.
}

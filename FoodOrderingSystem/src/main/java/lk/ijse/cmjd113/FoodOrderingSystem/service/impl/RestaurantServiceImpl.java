package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDAO restaurantDAO;

    @Override
    @Transactional(readOnly = true)
    public RestaurantEntity getCurrentUserRestaurant() {
        // 1. Token eken danata logwela ina kenege email eka gannawa
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        
        // 2. Ee email eken danata data base eke thiyana restaurant eka gannawa
        return restaurantDAO.findByOwnerEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("Restaurant not found for the current owner!"));
    }
}
package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDAO restaurantDAO;

    @Override
    public RestaurantEntity getCurrentUserRestaurant() {
        // 1. Token එකෙන් දැනට ලොග් වෙලා ඉන්න කෙනාගේ Email එක ගන්නවා
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        
        // 2. ඒ Email එකෙන් Database එකේ තියෙන කඩේ හොයලා දෙනවා
        return restaurantDAO.findByOwnerEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("Restaurant not found for the current owner!"));
    }
}
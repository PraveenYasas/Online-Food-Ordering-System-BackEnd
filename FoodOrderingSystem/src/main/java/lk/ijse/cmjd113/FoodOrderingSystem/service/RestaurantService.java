package lk.ijse.cmjd113.FoodOrderingSystem.service;

import org.springframework.web.multipart.MultipartFile;

import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;

public interface RestaurantService {
    RestaurantEntity getCurrentUserRestaurant();
    
    RestaurantEntity createRestaurant(String name, String address, String contactNumber, String ownerEmail, MultipartFile image);

    RestaurantEntity updateRestaurant(Long id, String name, String address, String contactNumber, MultipartFile image);
}
package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    @Transactional
    public RestaurantEntity createRestaurant(String name, String address, String contactNumber, MultipartFile image) {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setContactNumber(contactNumber);

        if (image != null && !image.isEmpty()) {
            try {
                String uploadDir = "uploads/images/";
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                
                restaurant.setImageUrl("/images/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store image file", e);
            }
        }
        return restaurantDAO.save(restaurant);
    }
}
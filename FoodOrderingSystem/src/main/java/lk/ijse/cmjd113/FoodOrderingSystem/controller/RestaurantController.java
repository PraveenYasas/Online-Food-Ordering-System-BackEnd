package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantDAO restaurantDAO;
    private final RestaurantService restaurantService; 

    @GetMapping
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantDAO.findAll();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RestaurantEntity> createRestaurant(
        @RequestParam("name") String name,
        @RequestParam("address") String address,
        @RequestParam("contactNumber") String contactNumber,
        @RequestParam(value = "image", required = false) MultipartFile image
    ) {
        RestaurantEntity savedRestaurant = restaurantService.createRestaurant(name, address, contactNumber, image);
        return ResponseEntity.ok(savedRestaurant);
    }
}
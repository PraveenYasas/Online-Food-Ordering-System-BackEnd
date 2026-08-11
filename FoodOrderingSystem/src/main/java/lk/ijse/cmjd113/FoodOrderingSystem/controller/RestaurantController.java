package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd113.FoodOrderingSystem.dao.RestaurantDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.RestaurantEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantDAO restaurantDAO;

    @GetMapping
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantDAO.findAll();
    }
}
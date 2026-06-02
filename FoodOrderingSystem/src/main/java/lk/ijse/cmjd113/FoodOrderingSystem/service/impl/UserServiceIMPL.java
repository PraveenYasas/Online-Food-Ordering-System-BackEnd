package lk.ijse.cmjd113.FoodOrderingSystem.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd113.FoodOrderingSystem.dao.UserDAO;
import lk.ijse.cmjd113.FoodOrderingSystem.dto.UserDTO;
import lk.ijse.cmjd113.FoodOrderingSystem.entities.UserEntity;
import lk.ijse.cmjd113.FoodOrderingSystem.service.UserService;

// Spring boot walata meka service ekak kiyala dana ganna me anotaion eka aniwaryai.

// @Service         - Me anotation eka dammahama springboot eka ibema meka service layyer eke class ekak widihata mathaka thiyagannawa.
//                  - Controller eken kathaa karapu gaman aran denawa
@Service        


@Transactional  // Database ekath ekka wada karaddi mokak hari awulak unoth okkoma apahu rollback karanna me anotaion eka udaw wenawa.

public class UserServiceIMPL implements UserService {

    // @Autowired  - meken karanne api kalin hadapu UserDAO intefce eke object ekak aluthen hadanne nathuwa (new UserDAO() kiyala gahanne nathuwa) springboot ekatama kiyala ibetama sambanda karana ekai.
    //             - mekata kiyanne dependency injection kiayana eka.

    @Autowired  // Api kalin hadapu UserDAO eka methanata sambanda karanawa.
    private UserDAO userDAO;

    // saveUser method eka mekata UserEntity ekak dunahama, eka kelinma ara userDAO.save() ekata pass karala database eke save karanawa.
    // Save wechcha data tika apahu return karanawa.
    // @Override
    // public UserEntity saveUser(UserEntity user) {
    //     return userDAO.save(user);  
    // }

    @Autowired
    private ModelMapper modelMapper;    // hadagaththa model mapper eka sambanda karagannawa.

    @Override
    public void saveUser(UserDTO userDto) {

        // UserEntity userEntity = new UserEntity();

        // userEntity.setFirstName(userDto.getFirstName());
        // userEntity.setLastName(userDto.getLastName());
        // userEntity.setEmail(userDto.getEmail());
        // userEntity.setPhoneNumber(userDto.getPhoneNumber());
        // userEntity.setPassword(userDto.getPassword());

                    // kalin peli 4k 5k liyapu eka dan eka peliyai.

                    // meken kiyanne userDTO eke thiyana data tika aragena aluth UserEntity ekak hadala ekata danna kiyana ekai.
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        userDAO.save(userEntity);
    }
}

package lk.ijse.cmjd113.FoodOrderingSystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration                  // meka configuration file eka kiyala Spring boot ekata kiyanwa.
public class CORSConfig {
    
    @Bean                       // meken karanne ModelMapper object ekak mulu app ekatama poduwe pawichchi karanna hadala den ekai.
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }  
}

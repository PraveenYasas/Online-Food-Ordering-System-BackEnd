package lk.ijse.cmjd113.FoodOrderingSystem.util;

import java.util.UUID;

import org.springframework.util.StringUtils;

public class FileUtil {

    public static String generateUniqueFileName(String originalFileName) {
        String cleanFileName = StringUtils.cleanPath(originalFileName);
        
        return UUID.randomUUID().toString() + "_" + cleanFileName;
    }
    
}
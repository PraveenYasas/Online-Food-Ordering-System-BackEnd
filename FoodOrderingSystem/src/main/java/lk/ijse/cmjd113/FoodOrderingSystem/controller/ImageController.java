package lk.ijse.cmjd113.FoodOrderingSystem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lk.ijse.cmjd113.FoodOrderingSystem.util.FileUtil;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImageController {

    private final String UPLOAD_DIR = "uploads/";

    // 🔥 1. ඔයාගේ පරණ Upload මෙතඩ් එක (මේක කිසිම වෙනසක් කරලා නෑ)
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String newFileName = FileUtil.generateUniqueFileName(file.getOriginalFilename());

            Path filePath = uploadPath.resolve(newFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String imageUrl = "/images/" + newFileName;
            return ResponseEntity.ok(imageUrl);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Image upload failed: " + e.getMessage());
        }
    }

    // 🔥 2. පින්තූර බ්‍රවුසරේ පෙන්නන සුපිරි GET මෙතඩ් එක (හැම තැනම හොයනවා)
    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String fileName) {
        try {
            // Working Directory එක මොකක්ද කියලා Console එකේ ප්‍රින්ට් කරනවා
            String userDir = System.getProperty("user.dir");
            System.out.println("========== IMAGE SEARCH ==========");
            System.out.println("Working Directory: " + userDir);
            System.out.println("Looking for File: " + fileName);

            // ෆයිල් එක තියෙන්න පුළුවන් හැම තැනම ලිස්ට් එකක්
            String[] possibleBases = {
                "uploads",
                "FoodOrderingSystem/uploads",
                userDir + "/uploads",
                userDir + "/FoodOrderingSystem/uploads"
            };

            Path filePath = null;

            // එකින් එක හොයලා බලනවා
            for (String base : possibleBases) {
                Path testPath = Paths.get(base).resolve(fileName).normalize();
                System.out.println("Trying path: " + testPath.toAbsolutePath());
                
                if (Files.exists(testPath)) {
                    filePath = testPath;
                    System.out.println("✅ MATCH FOUND AT: " + filePath.toAbsolutePath());
                    break;
                }
            }

            if (filePath != null) {
                Resource resource = new UrlResource(filePath.toUri());
                String contentType = Files.probeContentType(filePath);
                if (contentType == null) {
                    contentType = "image/jpeg";
                }
                System.out.println("==================================");
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                System.out.println("❌ FILE NOT FOUND ANYWHERE!");
                System.out.println("==================================");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
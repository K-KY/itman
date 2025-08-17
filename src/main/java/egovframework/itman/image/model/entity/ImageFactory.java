package egovframework.itman.image.model.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class ImageFactory {

    public static ImageFile toEntity(MultipartFile imageFile) throws IOException {
        return ImageFile.builder()
                .imageSeq(UUID.randomUUID().toString())
                .fileName(imageFile.getOriginalFilename())
                .contentType(imageFile.getContentType())
                .image(encoding(imageFile)).build();

    }

    private static String encoding(MultipartFile imageFile) throws IOException {
        return Base64.getEncoder().encodeToString(imageFile.getBytes());
    }
}

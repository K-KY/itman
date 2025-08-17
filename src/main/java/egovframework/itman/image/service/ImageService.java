package egovframework.itman.image.service;

import egovframework.itman.image.model.entity.ImageFactory;
import egovframework.itman.image.model.entity.ImageFile;
import egovframework.itman.image.model.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository repository;

    public ImageFile save(MultipartFile file) throws IOException {
        ImageFile img = ImageFactory.toEntity(file);
        return repository.save(img);
    }

    public ImageFile get(String id) {
        return repository.findByImageSeq(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

}

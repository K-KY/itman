package egovframework.itman.image.controller;

import egovframework.itman.image.dto.ImageFileDto;
import egovframework.itman.image.model.entity.ImageFile;
import egovframework.itman.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return service.save(file).getImageSeq();
    }

    @GetMapping("/{url}")
    public ResponseEntity<ImageFileDto> read(@PathVariable String url) {
        if (url == null || url.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ImageFile img = service.get(url);

        return ResponseEntity.of(
                Optional.of(
                        new ImageFileDto(img.getImageSeq(), img.getFileName(), img.getContentType(), img.getImage()))
        );

    }

}



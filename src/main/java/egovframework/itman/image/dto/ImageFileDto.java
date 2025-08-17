package egovframework.itman.image.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageFileDto {
        private String imageSeq;
        private String fileName;
        private String contentType;
        private String image;
}

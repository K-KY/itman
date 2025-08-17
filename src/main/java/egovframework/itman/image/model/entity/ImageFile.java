package egovframework.itman.image.model.entity;

import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageFile extends BaseTimeEntity {

    @Id
    private String imageSeq;

    @Lob
    @Column(columnDefinition = "LONGBLOB") // MySQL에서 큰 바이너리 저장
    private String image;


    private String fileName;

    private String contentType;
}

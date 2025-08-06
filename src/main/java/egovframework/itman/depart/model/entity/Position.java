package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 직급
 * */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Position extends BaseTimeEntity {
    public Position(PositionDto.Request request) {
        this.positionSeq = request.getSeq();
        this.positionName = request.getName();
        this.positionDescription = request.getDescription();
        del = request.getDel() != null && request.getDel();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer positionSeq;
    @Column
    private String positionName;
    @Column
    private String positionDescription;
    @Column
    private Boolean del;


    public PositionDto.Response toDto() {
        return PositionDto.Response.builder()
                .seq(this.positionSeq)
                .name(this.positionName)
                .description(this.positionDescription)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate()).build();
    }

    public static Position from(PositionDto.Request request) {
        return new Position(request);
    }
}

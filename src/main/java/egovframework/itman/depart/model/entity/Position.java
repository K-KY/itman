package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.group.model.entity.ManageGroupFactory;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

/**
 * 직위
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Position extends BaseTimeEntity {
    public Position(PositionDto.Request request) {
        this.positionSeq = request.getSeq();
        this.positionName = request.getName();
        this.positionDescription = request.getDescription();
        this.group = ManageGroupFactory.toCompactEntity(request.getGroupSeq());
        this.enabled = Optional.ofNullable(request.getEnabled()).orElse(true);
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
    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;
    @ManyToOne
    @JoinColumn(name = "grp_seq")
    private ManageGroup group;


    public PositionDto.Response toDto() {
        return PositionDto.Response.builder()
                .seq(this.positionSeq)
                .name(this.positionName)
                .description(this.positionDescription)
                .del(del)
                .enabled(enabled)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate()).build();
    }

    @Deprecated
    public static Position from(PositionDto.Request request) {
        return new Position(request);
    }

    public boolean disable() {
        this.enabled = !enabled;
        return enabled;
    }
}

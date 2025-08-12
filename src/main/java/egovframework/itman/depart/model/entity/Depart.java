package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
* 여기서 그룹정보를 같이 줄지 말지 ***고민중***
* */

/**
 * 부서
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Depart extends BaseTimeEntity {

    private Depart(DepartDto.Request request) {
        this.departName = request.getName();
        this.departSeq = request.getSeq();
        this.description = request.getDescription();
        this.del = request.getDel() != null && request.getDel();

    }

    @Id
    @Column(name = "depart_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departSeq;

    @Column(name = "depart_name")
    private String departName;

    //삭제상태
    @Column(name = "del", nullable = false)
    private boolean del = false;

    //사용안함 상태
    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "grp_seq")
    private ManageGroup group;

    public DepartDto.Response toDto() {
        return DepartDto.Response.builder()
                .seq(departSeq)
                .name(departName)
                .description(description)
                .del(del)
                .enabled(enabled)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate()).build();
    }

    public void change(DepartDto.Request departDto) {
        this.departName = departDto.getName();
        this.description = departDto.getDescription();
    }

    public Boolean disable() {
        this.enabled = !enabled;
        return enabled;
    }

    @Deprecated
    public static Depart from(DepartDto.Request request) {
        if (request == null) {
            return null;
        }
        return new Depart(request);
    }

}

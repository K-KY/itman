package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

    @Column(name = "del", nullable = false)
    private boolean del = false;

    @Column(name = "description")
    private String description;

    public DepartDto.Response toDto() {
        return DepartDto.Response.builder()
                .seq(departSeq)
                .name(departName)
                .description(description)
                .del(del)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate()).build();
    }

    public void change(DepartDto.Request departDto) {
        this.departName = departDto.getName();
        this.description = departDto.getDescription();
    }

    public static Depart from(DepartDto.Request request) {
        if (request == null) {
            return null;
        }
        return new Depart(request);
    }

}

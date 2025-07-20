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

    public Depart(DepartDto.Request request) {
        this.departName = request.getDepartName();
        this.departSeq = request.getDepartSeq();
    }

    @Id
    @Column(name = "depart_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departSeq;

    @Column(name = "depart_name")
    private String departName;

    @Column(name = "del", nullable = false)
    private boolean del = false;

    public DepartDto.Response toDto() {
        return DepartDto.Response.builder()
                .departSeq(departSeq)
                .departName(departName)
                .del(del)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate()).build();
    }

    public void change(DepartDto.Request departDto) {
        this.departName = departDto.getDepartName();
    }
}

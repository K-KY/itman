package egovframework.itman.depart.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import egovframework.itman.depart.dto.EmployeeDto;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 직원
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseTimeEntity {

    @Id
    @Column(name = "emp_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empSeq;

    @Column
    private String empName;

    @JoinColumn(name = "manager_seq", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference//순환참조 방지
    private Employee manager;

    @JoinColumn(name = "depart_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private Depart depart;//부서

    @JoinColumn(name = "job_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;//직무****************구현 해야함

    @JoinColumn(name = "position_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;//직급*****************구현 해야함

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean del = false;

    public EmployeeDto.Response toDto() {
        return EmployeeDto.Response.builder()
                .empSeq(empSeq)
                .empName(empName)
                .departDto(depart.toDto())
                .manager(toDto(manager))
                .del(del)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate())
                .build();
    }

    private EmployeeDto.Response toDto(Employee manager) {
        if (manager == null) {
            return null;
        }

        return EmployeeDto.Response.builder()
                .empSeq(manager.getEmpSeq())
                .empName(manager.getEmpName())
                .departDto(manager.getDepart().toDto())
                .del(manager.getDel())
                .createdDate(manager.getCreatedDate())
                .updatedDate(manager.getLastModifiedDate())
                .build();
    }

    //dto를 엔티티로 변경
    public static Employee from(EmployeeDto.Request request) {
        EmployeeDto.Request manager = request.getManager();
        //manager가 null인 경우
        if (manager == null) {
            return Employee.builder()
                    .empSeq(request.getEmpSeq())
                    .empName(request.getEmpName())
                    .depart(Depart.from(request.getDepartDto()))
                    .del(request.getDel() != null && request.getDel())
                    .job(null)
                    .position(null)
                    .build();
        }

        //manager가 null이 아닌경우
        Employee build = Employee.builder().empSeq(manager.getEmpSeq()).build();
        return Employee.builder()
                .empSeq(request.getEmpSeq())
                .empName(request.getEmpName())
                .depart(Depart.from(request.getDepartDto()))
                .manager(build)
                .del(request.getDel() != null && request.getDel())
                .job(null)
                .position(null)
                .build();

    }

    @Override
    public String toString() {
        return "Employee{" +
                "empSeq=" + empSeq +
                ", empName='" + empName + '\'' +
                ", manager=" + manager +
                ", depart=" + depart +
                ", job=" + job +
                ", position=" + position +
                ", del=" + del +
                '}';
    }

    public void change(EmployeeDto.Request request) {
        this.empName = request.getEmpName();
        this.depart = Depart.from(request.getDepartDto());
        this.manager = from(request);
        this.del = request.getDel();
        this.job = null;
        this.position = null;
    }
}

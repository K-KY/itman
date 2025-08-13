package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.group.model.entity.ManageGroupFactory;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;


/**
 * 직무
 * */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job extends BaseTimeEntity {

    private Job(JobDto.Request request) {
        this.jobSeq = request.getSeq();
        this.jobName = request.getName();
        this.jobDescription = request.getDescription();
        this.group = ManageGroupFactory.toCompactEntity(request.getGroupSeq());
        this.enabled = Optional.ofNullable(request.getEnabled()).orElse(true);
        del = request.getDel() != null && request.getDel();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobSeq;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_desc")
    private String jobDescription;
    //그룹

    @Column(name = "del")
    private boolean del;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "grp_seq")
    private ManageGroup group;

    public Boolean disable() {
        this.enabled = !enabled;
        return enabled;
    }

    public JobDto.Response toDto() {
        return JobDto.Response.builder()
                .seq(jobSeq)
                .name(jobName)
                .description(jobDescription)
                .del(del)
                .enabled(enabled)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate())
                .build();
    }

    @Deprecated
    public static Job from(JobDto.Request dto) {
        return new Job(dto);
    }
}

package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * 직무
 * */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job extends BaseTimeEntity {

    public Job(JobDto.Request request) {
        this.jobName = request.getJobName();
        this.jobDescription = request.getJobDescription();
        del = false;


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

    public JobDto.Response toDto() {
        return JobDto.Response.builder()
                .jobSeq(jobSeq)
                .jobName(jobName)
                .jobDescription(jobDescription)
                .del(del)
                .createdDate(super.getCreatedDate())
                .updatedDate(super.getLastModifiedDate())
                .build();
    }

    public static Job from(JobDto.Request dto) {
        return new Job(dto);
    }
}

package egovframework.itman.depart.model.entity;

import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * 직무
 * */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Job extends BaseTimeEntity {

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
}

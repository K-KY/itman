package egovframework.itman.depart.model.service.interfaces;


import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//TODO : 그룹 추가
public interface JobService {
    Job insert(JobDto.Request dto);

    Page<JobDto.Response> read(Pageable pageRequest);
    Page<JobDto.Response> read(Pageable pageRequest, Long groupSeq);

    Page<JobDto.Response> readAll(Pageable pageRequest);
    Page<JobDto.Response> readAll(Pageable pageRequest, Long groupSeq);



    Job update(JobDto.Request dto);

    boolean delete(JobDto.Request dto);

    Long countAll(boolean del);
    Long countAll(boolean del, Long groupSeq);

    Long count();
    Long count(Long groupSeq);

    JobDto.Response updateEnable(JobDto.Request dto);

}

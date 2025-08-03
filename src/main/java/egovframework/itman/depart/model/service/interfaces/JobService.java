package egovframework.itman.depart.model.service.interfaces;


import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//TODO : 그룹 추가
public interface JobService {
    Job insert(JobDto.Request dto);

    Page<JobDto.Response> read(Pageable pageRequest);

    Job update(JobDto.Request dto);

    boolean delete(JobDto.Request dto);

    Long countAll();

    Long count(boolean del);

}

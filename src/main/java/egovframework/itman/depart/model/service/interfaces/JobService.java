package egovframework.itman.depart.model.service.interfaces;


import egovframework.itman.depart.dto.JobDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//TODO : 그룹 추가
public interface JobService {
    JobDto.Response insert(JobDto.Request dto);

    Page<JobDto.Response> read(Pageable pageRequest);

    JobDto.Response update(JobDto.Request dto);

    boolean delete(JobDto.Request dto);

    Long countAll();

    Long count(boolean del);

}

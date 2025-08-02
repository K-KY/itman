package egovframework.itman.depart.model.service;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.repository.JobRepository;
import egovframework.itman.depart.model.service.interfaces.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobDto.Response insert(JobDto.Request dto) {

        return null;
    }

    @Override
    public Page<JobDto.Response> read(Pageable pageRequest) {
        return null;
    }

    @Override
    public JobDto.Response update(JobDto.Request dto) {
        return null;
    }

    @Override
    public boolean delete(JobDto.Request dto) {
        return false;
    }

    @Override
    public Long countAll() {
        return 0L;
    }

    @Override
    public Long count(boolean del) {
        return 0L;
    }
}

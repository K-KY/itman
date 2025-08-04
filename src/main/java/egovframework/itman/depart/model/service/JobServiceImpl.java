package egovframework.itman.depart.model.service;

import egovframework.itman.depart.dto.JobDto;
import egovframework.itman.depart.model.entity.Job;
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
    public Job insert(JobDto.Request dto) {
        Job from = Job.from(dto);
        return jobRepository.save(from);
        //
    }

    @Override
    public Page<JobDto.Response> read(Pageable pageRequest) {
        return jobRepository.findAllByDelFalse(pageRequest).map(Job::toDto);
    }

    @Override
    public Job update(JobDto.Request dto) {
        if (dto.getSeq() == null) {
            throw new IllegalArgumentException("수정할 게시물을 찾지 못했습니다.");
        }
        return jobRepository.save(Job.from(dto));
    }

    @Override
    public boolean delete(JobDto.Request dto) {
        return false;
    }

    @Override
    public Long countAll() {
        return jobRepository.count();
    }

    @Override
    public Long count(boolean del) {
        return jobRepository.countJobByDel(del);
    }
}

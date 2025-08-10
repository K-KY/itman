package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Page<Job> findAllByDelFalse(Pageable pageRequest);

    Long countJobByDel(boolean del);

    Optional<Job> findByJobSeq(Integer jobSeq);
}

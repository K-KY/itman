package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findAllByDelFalse(Pageable pageRequest);

    Long countJobByDel(boolean del);
}

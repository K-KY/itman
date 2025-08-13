package egovframework.itman.depart.model.repository;

import com.ibm.icu.impl.Trie2;
import egovframework.itman.depart.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Page<Job> findAllByDelFalse(Pageable pageRequest);
    Page<Job> findAllByDelFalseAndGroup_GroupSeq(Pageable pageRequest, Long groupSeq);

    Page<Job> findAllByDelFalseAndEnabledTrue(Pageable pageRequest);
    Page<Job> findAllByDelFalseAndEnabledTrueAndGroup_GroupSeq(Pageable pageRequest, Long groupSeq);


    Long countJobByDel(boolean del);

    Optional<Job> findByJobSeq(Integer jobSeq);

    Long countJobByDelFalseAndEnabledTrue();
}

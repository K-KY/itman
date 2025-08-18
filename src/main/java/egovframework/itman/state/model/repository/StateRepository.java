package egovframework.itman.state.model.repository;

import egovframework.itman.state.model.entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StateRepository extends JpaRepository<State, Long> {
    boolean existsByStateSeq(Long categorySeq);

    State findByStateSeq(Long categorySeq);

    Page<State> findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(Pageable pageable, Long groupSeq);

    State findByStateName(String categoryName);

    Optional<State> findByStateNameAndGroup_GroupSeq(String categoryName, Long groupGroupSeq);
}

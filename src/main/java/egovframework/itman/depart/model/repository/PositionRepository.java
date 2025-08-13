package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.model.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    //전체 조회
    Position findByPositionSeq(Integer departSeq);

    //del이 false인 행만 조회
    Page<Position> findAllByDelFalse(Pageable pageable);//그룹 조건 없이 조회
    Page<Position> findAllByDelFalseAndGroup_GroupSeq(Pageable pageable, Long groupSeq);// 그룹 조건 조회

    Page<Position> findAllByDelFalseAndEnabledTrue(Pageable pageable);//그룹 조건 없이 조회
    Page<Position> findAllByDelFalseAndEnabledTrueAndGroup_GroupSeq(Pageable pageable, Long groupSeq);// 그룹 조건 조회

    Long countPositionByEnabledTrueAndDelFalse();

    //departSeq가 일치하는 행 조회
    Position findByPositionSeqAndDelIsFalse(Integer departSeq);

    Long countPositionByDel(boolean del);
    Long countPositionByDelAndEnabled(boolean del, boolean enabled);

    Long countPositionByDelAndGroup_GroupSeq(boolean del, Long groupSeq);
    Long countPositionByDelAndEnabledAndGroup_GroupSeq(boolean del, boolean enabled, Long groupSeq);

    Long countPositionByEnabledTrueAndDelFalseAndGroup_GroupSeq(Long groupSeq);

}

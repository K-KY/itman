package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.model.entity.Depart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends JpaRepository<Depart, Long> {
    //전체 조회
    Depart findByDepartSeq(Integer departSeq);

    //del이 false인 행만 조회
    Page<Depart> findAllByDelFalse(Pageable pageable);

    //departSeq가 일치하는 행 조회
    Depart findByDepartSeqAndDelIsFalse(Integer departSeq);

    @Modifying
    @Query("UPDATE Depart d SET d.del = :del WHERE d.departSeq = :seq")
    Integer updateDelByDepartSeq(@Param("seq") Integer departSeq, @Param("del") Boolean del);


    Long countDepartByDel(boolean del);
}

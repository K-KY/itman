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
    Depart findByDepartSeq(Integer departSeq);

    Page<Depart> findAllByDelFalse(Pageable pageable);

    Depart findByDepartSeqAndDelIsFalse(Integer departSeq);

    @Modifying
    @Query("UPDATE Depart d SET d.del = :del WHERE d.departSeq = :seq")
    Integer updateDelByDepartSeq(@Param("seq") Integer departSeq, @Param("del") Boolean del);


    Long countDepartByDel(boolean del);
}

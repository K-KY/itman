package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByDelFalse(Pageable pageable);


    Employee findByEmpSeqAndDelFalse(Integer empSeq);

    @Modifying
    @Query("UPDATE Employee e SET e.del = :del WHERE e.empSeq = :seq")
    Integer updateDelByEmpSeq(@Param("seq") Integer empSeq, @Param("del") Boolean del);

}

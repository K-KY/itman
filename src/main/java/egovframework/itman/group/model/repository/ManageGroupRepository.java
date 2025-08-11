package egovframework.itman.group.model.repository;

import egovframework.itman.group.model.entity.ManageGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageGroupRepository extends JpaRepository<ManageGroup, Long> {

    Page<ManageGroup> findAllByDelFalseAndUser(UserDetails user, PageRequest pageRequest);

    ManageGroup findByGroupSeq(Long groupSeq);
}

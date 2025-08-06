package egovframework.itman.depart.model.repository;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.depart.model.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Page<Position> findAllByDelFalse(Pageable pageRequest);
}

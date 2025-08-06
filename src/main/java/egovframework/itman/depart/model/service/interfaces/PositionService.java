package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.depart.model.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
    Position insert(PositionDto.Request dto);

    Page<PositionDto.Response> read(Pageable pageRequest);

    Position update(PositionDto.Request dto);

    boolean delete(PositionDto.Request dto);

    Long countAll();

    Long count(boolean del);

}

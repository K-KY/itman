package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.DepartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartService {
    DepartDto.Response insert(DepartDto.Request dto);

    Page<DepartDto.Response> read(Pageable pageRequest);

    DepartDto.Response update(DepartDto.Request departDto);

    boolean delete(DepartDto.Request departDto);
}

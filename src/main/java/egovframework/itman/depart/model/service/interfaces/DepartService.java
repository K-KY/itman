package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.DepartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface DepartService {
    DepartDto.Response insert(DepartDto.Request dto);

    Page<DepartDto.Response> read(Pageable pageRequest);

    DepartDto.Response update(DepartDto.Request departDto);

    Page<DepartDto.Response> readAll(PageRequest pageRequest);

    boolean delete(DepartDto.Request departDto);

    Long countAll(boolean del);

    Long count();

    DepartDto.Response updateEnable(DepartDto.Request departDto);
}

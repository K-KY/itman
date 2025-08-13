package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.DepartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface DepartService {
    DepartDto.Response insert(DepartDto.Request dto);
    DepartDto.Response insertGroup(DepartDto.Request dto);
//    DepartDto.Response insert(DepartDto.Request dto, Long groupSeq);

    Page<DepartDto.Response> read(Pageable pageRequest);
    Page<DepartDto.Response> read(Pageable pageRequest, Long groupSeq);

    Page<DepartDto.Response> readAll(PageRequest pageRequest);
    Page<DepartDto.Response> readAll(PageRequest pageRequest, Long groupSeq);

    DepartDto.Response update(DepartDto.Request departDto);

    boolean delete(DepartDto.Request departDto);

    Long countAll(boolean del);
    Long countAll(boolean del, Long groupSeq);

    Long count();
    Long count(Long groupSeq);

    DepartDto.Response updateEnable(DepartDto.Request departDto);
}

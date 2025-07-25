package egovframework.itman.depart.model.service.interfaces;

import egovframework.itman.depart.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeDto.Response insert(EmployeeDto.Request request);

    Page<EmployeeDto.Response> read(Pageable pageRequest);

    EmployeeDto.Response update(EmployeeDto.Request request);

    boolean delete(Integer empSeq);

}

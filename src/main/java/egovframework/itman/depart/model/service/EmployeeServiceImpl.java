package egovframework.itman.depart.model.service;

import egovframework.itman.depart.dto.EmployeeDto;
import egovframework.itman.depart.model.entity.DepartFactory;
import egovframework.itman.depart.model.entity.Employee;
import egovframework.itman.depart.model.repository.EmployeeRepository;
import egovframework.itman.depart.model.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//TODO : 회원, 인증, 그룹, 직무, 직책, 테스트
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public EmployeeDto.Response insert(EmployeeDto.Request request) {
        return employeeRepository.save(DepartFactory.toEntity(request)).toDto();
    }

    @Override
    public Page<EmployeeDto.Response> read(Pageable pageRequest) {
        return employeeRepository.findAllByDelFalse(pageRequest).map(Employee::toDto);
    }

    @Override
     //그룹조건 조회
    public Page<EmployeeDto.Response> read(Pageable pageRequest, Long groupSeq) {
        return employeeRepository.findAllByDelFalseAndGroup_GroupSeq(pageRequest, groupSeq).map(Employee::toDto);
    }

    @Transactional
    @Override
    public EmployeeDto.Response update(EmployeeDto.Request request) {
        Employee emp = employeeRepository.findByEmpSeqAndDelFalse(request.getEmpSeq());
        emp.change(request);
        return emp.toDto();
    }

    @Transactional
    @Override
    public boolean delete(Integer empSeq) {
        return employeeRepository.updateDelByEmpSeq(empSeq, true) == 1;
    }

    @Override
    public Long count(boolean del) {
        return employeeRepository.countEmployeeByDelIs(del);
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }

    @Override
    public Long count(boolean del, Long groupSeq) {
        return employeeRepository.countEmployeeByDelAndGroup_GroupSeq(del, groupSeq);
    }

    @Override
    public Long count(Long groupSeq) {
        return employeeRepository.countEmployeeByGroup_GroupSeq(groupSeq);
    }
}

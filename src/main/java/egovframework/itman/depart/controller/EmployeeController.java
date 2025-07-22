package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.EmployeeDto;
import egovframework.itman.depart.model.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeDto.Response> read(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<EmployeeDto.Response> read = employeeService.read(pageRequest);
        return read;
    }

    @PostMapping
    public EmployeeDto.Response create(@RequestBody EmployeeDto.Request request) {
        return employeeService.insert(request);
    }

    @PatchMapping
    public EmployeeDto.Response update(@RequestBody EmployeeDto.Request request) {
        return employeeService.update(request);
    }

    @DeleteMapping
    public boolean delete(@RequestBody EmployeeDto.Request request) {
        return employeeService.delete(request.getEmpSeq());
    }

}

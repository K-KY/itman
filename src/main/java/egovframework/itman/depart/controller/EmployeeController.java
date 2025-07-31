package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.EmployeeDto;
import egovframework.itman.depart.model.service.interfaces.EmployeeService;
import egovframework.itman.util.dto.SortDto;
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
        return employeeService.read(pageRequest);
    }

    @GetMapping("sort")
    public Page<EmployeeDto.Response> readSort(int page, int size, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return employeeService.read(pageRequest);
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

    @GetMapping("/count/{del}")
    public Long count(@PathVariable boolean del) {
        return employeeService.count(del);
    }

    @GetMapping("/count")
    public Long count() {
        return employeeService.count();
    }
}

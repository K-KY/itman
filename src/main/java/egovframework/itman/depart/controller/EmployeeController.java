package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.EmployeeDto;
import egovframework.itman.depart.model.service.interfaces.EmployeeService;
import egovframework.itman.user.model.entity.User;
import egovframework.itman.util.dto.SortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public Page<EmployeeDto.Response> read(int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page - 1, size);
//        return employeeService.read(pageRequest);
//    }

    /**
     * <table>
     *     <tr>
     *         <th>
     *             page
     *         </th>
     *         <th>
     *             size
     *         </th>
     *         <th>
     *             sort
     *         </th>
     *     </tr>
     *     <tr>
     *         <td>
     *             int
     *         </td>
     *         <td>
     *             int
     *         </td>
     *         <td>
     *             String(ASC, DESC) <br>
     *             , String(columns)
     *         </td>
     *     </tr>
     * </table>
     * */

    @GetMapping
    public Page<EmployeeDto.Response> read(int page, int size, Long groupSeq, SortDto sort,
    @AuthenticationPrincipal User user) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return employeeService.read(pageRequest, groupSeq);
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
    public boolean delete(@RequestBody EmployeeDto.Request request, @AuthenticationPrincipal User user) {
        return employeeService.delete(request.getEmpSeq());
    }

    @GetMapping("/count/{del}")
    public Long count(@PathVariable boolean del, Long groupSeq) {
        return employeeService.count(del, groupSeq);
    }

    @GetMapping("/count")
    public Long count(Long groupSeq) {
        return employeeService.count(groupSeq);
    }
}

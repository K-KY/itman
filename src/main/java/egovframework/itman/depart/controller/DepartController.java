package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.depart.model.service.interfaces.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departs")
public class DepartController {

    @Autowired
    private DepartService departService;
    //TODO: 회원인증, 그룹 추가

    /**
     * <table>
     *     <tr>
     *         <th>
     *             <strong>부서명</strong>
     *         </th>
     *         <th>
     *             <strong>멤버</strong>
     *         </th>
     *         <th>
     *             <strong>그룹</strong>
     *         </th>
     *     </tr>
     *     <tr>
     *         <td>String</td>
     *         <td>Integer(pk)</td>
     *         <td>Integer(pk)</td>
     *     </tr>
     *     <p>어떤 멤버의 어떤 그룹에 어떤 부서명 추가</p>
     * </table>
     */
    @PostMapping
    public DepartDto.Response insert(@RequestBody DepartDto.Request departDto) {
        return departService.insert(departDto);
    }

    /**
     * <Table>
     * <tr>
     * <th>페이지</th>
     * <th>페이지 사이즈</th>
     * </tr>
     * <tr>
     * <td>
     * Integer
     * </td>
     * <td>
     * Integer
     * </td>
     * </tr>
     * </Table>
     */
    @GetMapping
    public Page<DepartDto.Response> selectDepart(int page, int size) {
        Pageable pageRequest = PageRequest.of(page - 1, size, Sort.by("departSeq").descending());
        return departService.read(pageRequest);
    }

    @GetMapping("/count")
    public Long departCount() {
        return departService.countAll();
    }

    @GetMapping("/count/{del}")
    public Long departCount(@PathVariable boolean del) {
        return departService.count(del);
    }

    @PatchMapping
    public DepartDto.Response update(@RequestBody DepartDto.Request departDto) {
        return departService.update(departDto);
    }

    @DeleteMapping
    public Boolean delete(@RequestBody DepartDto.Request departDto) {
        return departService.delete(departDto);
    }

}


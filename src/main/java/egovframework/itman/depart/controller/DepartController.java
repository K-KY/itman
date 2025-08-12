package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.depart.model.service.interfaces.DepartService;
import egovframework.itman.util.dto.SortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @GetMapping("/all")
    public Page<DepartDto.Response> readAllDepart(int page, int size, long groupSeq, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return departService.readAll(pageRequest, groupSeq);
    }

    @GetMapping
    public Page<DepartDto.Response> readDepart(int page, int size, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return departService.read(pageRequest);
    }

    @GetMapping("/count/{del}")
    public Long departCount(@PathVariable boolean del) {
        return departService.countAll(del);
    }

    @GetMapping("/count")
    public Long departCount() {
        return departService.count();
    }

    @PatchMapping
    public DepartDto.Response update(@RequestBody DepartDto.Request departDto) {
        return departService.update(departDto);
    }

    @PatchMapping("/enable")
    public DepartDto.Response enable(@RequestBody DepartDto.Request departDto) {
        return departService.updateEnable(departDto);
    }

    @DeleteMapping
    public Boolean delete(@RequestBody DepartDto.Request departDto) {
        return departService.delete(departDto);
    }

}


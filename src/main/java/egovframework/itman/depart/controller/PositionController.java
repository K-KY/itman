package egovframework.itman.depart.controller;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.depart.model.service.interfaces.PositionService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("positions")
@RequiredArgsConstructor
@RestController
public class PositionController {

    private final PositionService positionService;

    @GetMapping//enabled false 인 행은 조회 안함
    public Page<PositionDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return positionService.read(pageRequest, groupSeq);
    }

    @GetMapping("/all")//비활성된 게시물도 조회
    public Page<PositionDto.Response> readAll(int page, int size, Long groupSeq, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, sort.getSorts());
        return positionService.readAll(pageRequest, groupSeq);
    }

    @PostMapping
    public PositionDto.Response insert(@RequestBody PositionDto.Request dto) {
        return positionService.insert(dto).toDto();
    }

    @PatchMapping
    public PositionDto.Response update(@RequestBody PositionDto.Request dto) {
        return positionService.update(dto).toDto();
    }

    @PatchMapping("/enable")
    public PositionDto.Response enable(@RequestBody PositionDto.Request dto) {
        return positionService.updateEnable(dto);
    }

    @GetMapping("/count/{del}")
    public Long countJobs(@PathVariable boolean del, Long groupSeq) {
        return positionService.countAll(del, groupSeq);
    }

    @GetMapping("/count")
    public Long countJobs(Long groupSeq) {
        return positionService.count(groupSeq);
    }
}
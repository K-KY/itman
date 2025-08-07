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

    @GetMapping
    public Page<PositionDto.Response> read(int page, int size, SortDto sort) {
        PageRequest pageRequest = PageRequest.of(page, size, sort.getSorts());
        return positionService.read(pageRequest);
    }

    @PostMapping
    public PositionDto.Response insert(@RequestBody PositionDto.Request dto) {
        return positionService.insert(dto).toDto();
    }

    @PatchMapping
    public PositionDto.Response update(@RequestBody PositionDto.Request dto) {
        return positionService.update(dto).toDto();
    }
}
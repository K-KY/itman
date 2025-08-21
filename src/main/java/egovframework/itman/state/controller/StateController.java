package egovframework.itman.state.controller;

import egovframework.itman.state.dto.StateDto;
import egovframework.itman.state.model.entity.StateFactory;
import egovframework.itman.state.model.service.interfaces.StateService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("states")
public class StateController {

    private final StateService stateService;

    @GetMapping
    public Page<StateDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        return stateService.read(page - 1, size, groupSeq, sort).map(StateFactory::toDto);
    }

    @GetMapping("/all")
    public Page<StateDto.Response> readAll(int page, int size, Long groupSeq, SortDto sort) {
        return stateService.readAll(page - 1, size, groupSeq, sort).map(StateFactory::toDto);
    }


    @PostMapping
    public StateDto.Response create(@RequestBody StateDto.Request stateDto) {
        return StateFactory.toDto(stateService.create(stateDto));
    }

    @PatchMapping
    public StateDto.Response update(@RequestBody StateDto.Request stateDto) {
        return StateFactory.toDto(stateService.update(stateDto));
    }

    @PatchMapping("/enable")
    public StateDto.Response enable(@RequestBody StateDto.Request stateDto) {
        return StateFactory.toDto(stateService.updateEnable(stateDto));
    }

}

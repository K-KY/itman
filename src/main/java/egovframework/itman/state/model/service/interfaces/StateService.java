package egovframework.itman.state.model.service.interfaces;

import egovframework.itman.state.dto.StateDto;
import egovframework.itman.state.model.entity.State;
import egovframework.itman.util.dto.SortDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StateService {
    Page<State> read(int page, int size, Long groupSeq, SortDto sort);

    Optional<State> read(String name, Long groupSeq);//분류 중복 처리용

    State create(StateDto.Request categoryDto);

    State update(StateDto.Request categoryDto);
}

package egovframework.itman.state.model.service;

import egovframework.itman.state.dto.StateDto;
import egovframework.itman.state.model.entity.State;
import egovframework.itman.state.model.entity.StateFactory;
import egovframework.itman.state.model.repository.StateRepository;
import egovframework.itman.state.model.service.interfaces.StateService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<State> read(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page, size, sort.getSorts());
        return stateRepository.findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    public Page<State> readAll(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page, size, sort.getSorts());
        return stateRepository.findAllByDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    public Optional<State> read(String name, Long groupSeq) {
        return stateRepository.findByStateNameAndGroup_GroupSeq(name, groupSeq);
    }

    @Override
    @Transactional
    public State create(StateDto.Request stateDto) {
        State read = read(stateDto.getName(), stateDto.getGroupSeq()).orElse(null);
        if (read != null && !Objects.equals(stateDto.getSeq(), read.getStateSeq())) {
            throw new IllegalArgumentException("같은 이름의 상태가 존재합니다.");
        }
        State state = StateFactory.toEntity(stateDto);
        return stateRepository.save(state);
    }

    @Override
    @Transactional
    public State update(StateDto.Request stateDto) {
        State read = read(stateDto.getName(), stateDto.getGroupSeq()).orElse(null);
        if (read != null && !Objects.equals(stateDto.getSeq(), read.getStateSeq())) {
            throw new IllegalArgumentException("같은 이름의 상태가 존재합니다.");
        }

        State state = stateRepository.findByStateSeq(stateDto.getSeq());
        state.change(stateDto);
        return state;
    }

    @Override
    public State updateEnable(StateDto.Request stateDto) {
        State read = read(stateDto.getName(), stateDto.getGroupSeq()).orElse(null);
        if (read == null) {
            throw new IllegalArgumentException("데이터를 찾을 수 없습니다");
        }

        read.changeEnable(stateDto);
        return read;
    }

}

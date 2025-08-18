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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<State> read(int page, int size, Long groupSeq, SortDto sort) {
        Pageable pageable = PageRequest.of(page, size, sort.getSorts());
        return categoryRepository.findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    public Optional<State> read(String name, Long groupSeq) {
        return categoryRepository.findByStateNameAndGroup_GroupSeq(name, groupSeq);
    }

    @Override
    @Transactional
    public State create(StateDto.Request categoryDto) {
        Optional<State> read = read(categoryDto.getStateName(), categoryDto.getGroupSeq());
        if (read.isPresent()) {
            throw new IllegalArgumentException("같은 이름의 분류가 존재합니다.");
        }
        State category = StateFactory.toEntity(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public State update(StateDto.Request categoryDto) {
        Optional<State> read = read(categoryDto.getStateName(), categoryDto.getGroupSeq());
        if (read.isPresent()) {
            throw new IllegalArgumentException("같은 이름의 분류가 존재합니다.");
        }

        System.out.println("categoryDto = " + categoryDto);


        State category = categoryRepository.findByStateSeq(categoryDto.getStateSeq());
        category.change(categoryDto);
        return category;
    }

}

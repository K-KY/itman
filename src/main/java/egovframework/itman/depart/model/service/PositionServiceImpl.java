package egovframework.itman.depart.model.service;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.depart.model.entity.Position;
import egovframework.itman.depart.model.repository.PositionRepository;
import egovframework.itman.depart.model.service.interfaces.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository repository;

    @Override
    public Position insert(PositionDto.Request dto) {
        Position from = Position.from(dto);
        return repository.save(from);
    }

    @Override
    public Page<PositionDto.Response> read(Pageable pageRequest) {
        return repository.findAllByDelFalse(pageRequest).map(Position::toDto);
    }

    @Override
    public Page<PositionDto.Response> readAll(Pageable pageRequest, Long groupSeq) {
        return repository.findAllByDelFalseAndGroup_GroupSeq(pageRequest, groupSeq).map(Position::toDto);
    }

    @Override
    public Page<PositionDto.Response> read(PageRequest pageRequest, Long groupSeq) {
        return repository.findAllByDelFalseAndEnabledTrueAndGroup_GroupSeq(pageRequest, groupSeq).map(Position::toDto);
    }

    @Override
    public Position update(PositionDto.Request dto) {
        if (dto.getSeq() == null) {
            throw new IllegalArgumentException();
        }
        return repository.save(Position.from(dto));
    }

    @Override
    public boolean delete(PositionDto.Request dto) {
        return false;
    }

    @Override
    public Long countAll(boolean del) {
        return repository.countPositionByDel(del);
    }

    @Override
    public Long count() {
        return repository.countPositionByEnabledTrueAndDelFalse();
    }

    @Override
    public Long countAll(boolean del, Long groupSeq) {
        return repository.countPositionByDelAndGroup_GroupSeq(del, groupSeq);
    }

    @Override
    public Long count(Long groupSeq) {
        return repository.countPositionByEnabledTrueAndDelFalseAndGroup_GroupSeq(groupSeq);
    }

    @Override
    public PositionDto.Response updateEnable(PositionDto.Request dto) {
        if (dto.getSeq() == null) {
            throw new IllegalArgumentException("수정할 게시물을 찾지 못했습니다.");
        }
        Position position = repository.findByPositionSeq((dto.getSeq()));
        position.disable();
        return position.toDto();
    }
}

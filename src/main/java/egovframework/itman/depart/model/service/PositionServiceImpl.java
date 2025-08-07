package egovframework.itman.depart.model.service;

import egovframework.itman.depart.dto.PositionDto;
import egovframework.itman.depart.model.entity.Position;
import egovframework.itman.depart.model.repository.PositionRepository;
import egovframework.itman.depart.model.service.interfaces.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public Long countAll() {
        return 0L;
    }

    @Override
    public Long count(boolean del) {
        return 0L;
    }
}

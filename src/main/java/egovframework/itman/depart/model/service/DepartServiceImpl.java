package egovframework.itman.depart.model.service;


import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.depart.model.entity.Depart;
import egovframework.itman.depart.model.entity.DepartFactory;
import egovframework.itman.depart.model.repository.DepartRepository;
import egovframework.itman.depart.model.service.interfaces.DepartService;
import lombok.RequiredArgsConstructor;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class DepartServiceImpl extends EgovAbstractMapper implements DepartService {

    private final DepartRepository repository;

    //TODO : 회원 인증, 그룹 인증 권한 인증

    @Transactional
    @Override
    public DepartDto.Response insert(DepartDto.Request dto) {
        Depart depart = DepartFactory.toEntity(dto);
        return DepartFactory.toResponse(repository.save(depart));
    }

    @Override
    public Page<DepartDto.Response> read(Pageable pageRequest) {
        return repository.findAllByDelFalseAndEnabledTrue(pageRequest).map(DepartFactory::toResponse);
    }

    @Override
    public Page<DepartDto.Response> readAll(PageRequest pageRequest, long groupSeq) {
        return repository.findAllByDelFalseAndGroup_GroupSeq(pageRequest, groupSeq).map(DepartFactory::toResponse);
    }

    @Transactional
    @Override
    public DepartDto.Response update(DepartDto.Request departDto) {
        Depart depart = repository.findByDepartSeq(departDto.getSeq());
        depart.change(departDto);
        return DepartFactory.toResponse(depart);
    }

    @Transactional
    @Override
    public boolean delete(DepartDto.Request departDto) {
        return repository.updateDelByDepartSeq(departDto.getSeq(), true) == 1;
    }

    @Override
    public Long countAll(boolean del) {
        return repository.countDepartByDel(del);
    }

    @Override
    public Long count() {
        return repository.countDepartByEnabledTrueAndDelFalse();
    }

    @Override
    @Transactional
    public DepartDto.Response updateEnable(DepartDto.Request departDto) {
        Depart depart = repository.findByDepartSeq(departDto.getSeq());
        depart.disable();
        return DepartFactory.toResponse(depart);
    }

}

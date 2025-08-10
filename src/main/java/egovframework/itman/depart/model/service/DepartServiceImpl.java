package egovframework.itman.depart.model.service;


import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.depart.model.entity.Depart;
import egovframework.itman.depart.model.repository.DepartRepository;
import egovframework.itman.depart.model.service.interfaces.DepartService;
import lombok.AllArgsConstructor;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class DepartServiceImpl extends EgovAbstractMapper implements DepartService {

    @Autowired
    private final DepartRepository repository;

    //TODO : 회원 인증, 그룹 인증 권한 인증

    @Transactional
    @Override
    public DepartDto.Response insert(DepartDto.Request dto) {
        return repository.save(DepartDto.toEntity(dto)).toDto();
    }

    @Override
    public Page<DepartDto.Response> read(Pageable pageRequest) {
        return repository.findAllByDelFalse(pageRequest).map(Depart::toDto);
    }

    @Transactional
    @Override
    public DepartDto.Response update(DepartDto.Request departDto) {
        Depart depart = repository.findByDepartSeq(departDto.getSeq());
        depart.change(departDto);
        return DepartDto.from(depart);
    }

    @Transactional
    @Override
    public boolean delete(DepartDto.Request departDto) {
        return repository.updateDelByDepartSeq(departDto.getSeq(), true) == 1;
    }

    @Override
    public Long countAll() {
        return repository.count();
    }

    @Override
    public Long count(boolean del) {
        return repository.countDepartByDel(del);
    }

    @Override
    @Transactional
    public DepartDto.Response updateEnable(DepartDto.Request departDto) {
        Depart depart = repository.findByDepartSeq(departDto.getSeq());
        depart.disable();
        return depart.toDto();
    }

}

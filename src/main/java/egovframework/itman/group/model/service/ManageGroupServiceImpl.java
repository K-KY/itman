package egovframework.itman.group.model.service;

import egovframework.itman.group.dto.ManageGroupDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.group.model.entity.ManageGroupFactory;
import egovframework.itman.group.model.repository.ManageGroupRepository;
import egovframework.itman.group.model.service.interfaces.ManageGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ManageGroupServiceImpl implements ManageGroupService {

    @Autowired
    private final ManageGroupRepository groupRepository;
    @Autowired
    private final ManageGroupFactory factory;


    @Override
    public Page<ManageGroupDto.Response> read(UserDetails user, PageRequest pageRequest) {
        return groupRepository.findAllByDelFalseAndUser(user, pageRequest).map(factory::from);
    }

    @Override
    public ManageGroupDto.Response create(UserDetails user, ManageGroupDto.Request dto) {
        ManageGroup manageGroup = factory.of(user, dto);
        manageGroup = groupRepository.save(manageGroup);
        return factory.from(manageGroup);
    }

    @Override
    public ManageGroupDto.Response update(UserDetails user, ManageGroupDto.Request dto) {
        ManageGroup group = groupRepository.findByGroupSeq(dto.getGroupSeq());
        if (group.isMine(user)) {
            ManageGroup manageGroup = factory.of(user, dto);
            group = groupRepository.save(manageGroup);
            return factory.from(group);
        }
        throw new IllegalArgumentException("사용자가 소유한 그룹이 아닙니다.") ;
    }
}

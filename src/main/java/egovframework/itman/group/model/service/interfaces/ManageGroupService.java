package egovframework.itman.group.model.service.interfaces;

import egovframework.itman.group.dto.ManageGroupDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface ManageGroupService {

    Page<ManageGroupDto.Response> read(UserDetails user, PageRequest pageRequest);

    ManageGroupDto.Response create(UserDetails user, ManageGroupDto.Request dto);

    ManageGroupDto.Response update(UserDetails user, ManageGroupDto.Request dto);

    Long getCountAll(Long groupSeq);

    Long getCountAllAndDelFalse(Long groupSeq, Boolean del);
}
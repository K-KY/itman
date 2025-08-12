package egovframework.itman.group.model.service;

import egovframework.itman.group.dto.GroupInfoDto;
import egovframework.itman.group.model.repository.GroupDAO;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageGroupBatisService extends EgovAbstractServiceImpl {

    @Autowired
    private GroupDAO groupDAO;

    public GroupInfoDto getGroupInfo(Long groupSeq) {
        GroupInfoDto groupInfoDto = groupDAO.selectGroupInfo(groupSeq);
        return groupInfoDto;
    }
}

package egovframework.itman.group.model.repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.itman.group.dto.GroupInfoDto;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO extends EgovComAbstractDAO {

    public GroupInfoDto selectGroupInfo(Long grpSeq) {
        return selectOne("GroupInfoDAO.selectGroupInfo", grpSeq);
    }
}
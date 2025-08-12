package egovframework.itman.group.model.service;

import egovframework.itman.group.dto.GroupInfoDto;
import egovframework.itman.group.dto.ManageGroupDto;
import egovframework.itman.group.model.repository.ManageGroupRepository;
import egovframework.itman.group.model.service.interfaces.ManageGroupService;
import egovframework.itman.user.model.entity.User;
import egovframework.itman.user.model.service.login.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class GroupServiceTest {

    @Autowired
    private ManageGroupBatisService groupService;
    @Autowired
    private ManageGroupService manageGroupService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ManageGroupRepository manageGroupRepository;

    @BeforeEach
    void init() {
        userRepository.deleteAll();
        manageGroupRepository.deleteAll();
    }

    @Test
    @Transactional
    void 그룹_생성_테스트() throws Exception {
        User user = new User(null, "1@2.3", bCryptPasswordEncoder.encode("kky"),
                "kky", "ROLE_USER", false);
        userRepository.save(user);

        ManageGroupDto.Request test = new ManageGroupDto.Request(1L, "test", false);

        ManageGroupDto.Response response = manageGroupService.create(user, test);
        assertThat(response.getGroupName()).isEqualTo("test");
    }

    @Test
    @Transactional
    void 그룹_정보_테스트() throws Exception {
        User user = new User(null, "1@2.3", bCryptPasswordEncoder.encode("kky"),
                "kky", "ROLE_USER", false);
        userRepository.save(user);

        ManageGroupDto.Request test = new ManageGroupDto.Request(1L, "test", false);

        ManageGroupDto.Response response = manageGroupService.create(user, test);

        GroupInfoDto groupInfo = groupService.getGroupInfo(response.getGroupSeq());
        assertThat(groupInfo.getDeparts()).isEqualTo(0);
        assertThat(groupInfo.getEmployees()).isEqualTo(0);
        System.out.println("groupInfo = " + groupInfo);
    }
}
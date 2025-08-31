package egovframework.itman.group.controller;

import egovframework.itman.group.dto.GroupInfoDto;
import egovframework.itman.group.dto.ManageGroupDto;
import egovframework.itman.group.model.service.ManageGroupBatisService;
import egovframework.itman.group.model.service.interfaces.ManageGroupService;
import egovframework.itman.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private final ManageGroupService groupService;

    @Autowired
    private final ManageGroupBatisService groupBatisService;

    @GetMapping
    public Page<ManageGroupDto.Response> read(@AuthenticationPrincipal User user, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return groupService.read(user, pageRequest);

    }

    @GetMapping("info")
    public GroupInfoDto readGroup(@AuthenticationPrincipal User user, Long groupSeq) {
        return groupBatisService.getGroupInfo(groupSeq);
    }

    @PostMapping
    public ManageGroupDto.Response create(@AuthenticationPrincipal User user, @RequestBody ManageGroupDto.Request dto) {
        return groupService.create(user, dto);
    }

    @PatchMapping
    public ManageGroupDto.Response update(@AuthenticationPrincipal User user, @RequestBody ManageGroupDto.Request dto) {
        return groupService.update(user, dto);
    }

    @GetMapping("count")
    public Long count(@AuthenticationPrincipal User user, Long groupSeq) {
        return groupService.getCountAll(groupSeq);
    }

    @GetMapping("count/{del}")
    public Long count(@AuthenticationPrincipal User user, Long groupSeq, @PathVariable Boolean del) {
        return groupService.getCountAllAndDelFalse(groupSeq, del);
    }
}

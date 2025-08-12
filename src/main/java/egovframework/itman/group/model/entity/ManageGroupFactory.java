package egovframework.itman.group.model.entity;

import egovframework.itman.group.dto.ManageGroupDto;
import egovframework.itman.user.dto.UserDto;
import egovframework.itman.user.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class ManageGroupFactory {
    public static ManageGroup of(UserDetails user, ManageGroupDto.Request dto) {
        return ManageGroup.builder()
                .groupSeq(dto.getGroupSeq())
                .groupName(dto.getGroupName())
                .del(Optional.of(dto.isDel()).orElse(false))
                .user((User) user)
                .build();
    }

    public static ManageGroupDto.Response toResponse(ManageGroup group) {
        return ManageGroupDto.Response.builder()
                .groupSeq(group.getGroupSeq())
                .groupName(group.getGroupName())
                .user(UserDto.from(group.getUser()))
                .del(group.isDel())
                .createdDate(group.getCreatedDate())
                .modifiedDate(group.getLastModifiedDate())
                .build();
    }
}

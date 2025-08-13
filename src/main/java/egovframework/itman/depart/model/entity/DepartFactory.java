package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.group.model.entity.ManageGroupFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DepartFactory {

    public static DepartDto.Response toResponse(Depart depart) {
        return DepartDto.Response.builder()
                .seq(depart.getDepartSeq())
                .name(depart.getDepartName())
                .description(depart.getDescription())
                .del(depart.isDel())
                .enabled(depart.isEnabled())
//                .group(ManageGroupFactory.toResponse(depart.getGroup()))
                .createdDate(depart.getCreatedDate())
                .updatedDate(depart.getLastModifiedDate())
                .build();
    }

    public static Depart toEntity(DepartDto.Request dto) {
//        return Depart.from(dto);
        ManageGroup compactGroup = ManageGroupFactory.toCompactEntity(dto.getGroupSeq());
        return Depart.builder()
                .departSeq(dto.getSeq())
                .departName(dto.getName())
                .description(dto.getDescription())
                .group(compactGroup)
                .del(Optional.ofNullable(dto.getDel()).orElse(false))
                .enabled(Optional.ofNullable(dto.getEnabled()).orElse(true))
                .build();
    }

//    public static Depart toEntity(DepartDto.Request dto, Long groupSeq) {
//        ManageGroup compactGroup = ManageGroupFactory.toCompactEntity(groupSeq);
//        return new Depart(dto.getSeq(), dto.getName(), dto.getDel()
//                , dto.getEnabled(), dto.getDescription(),
//                compactGroup);
//    }
}

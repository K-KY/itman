package egovframework.itman.depart.model.entity;

import egovframework.itman.depart.dto.DepartDto;
import egovframework.itman.group.model.entity.ManageGroupFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartFactory {

    public static DepartDto.Response toResponse(Depart depart) {
        return DepartDto.Response.builder()
                .seq(depart.getDepartSeq())
                .name(depart.getDepartName())
                .description(depart.getDescription())
                .del(depart.isDel())
                .enabled(depart.isEnabled())
                .group(ManageGroupFactory.toResponse(depart.getGroup()))
                .createdDate(depart.getCreatedDate())
                .updatedDate(depart.getLastModifiedDate())
                .build();
    }

    public static Depart toEntity(DepartDto.Request dto) {
        return Depart.from(dto);
    }
}

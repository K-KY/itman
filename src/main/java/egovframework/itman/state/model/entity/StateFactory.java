package egovframework.itman.state.model.entity;

import egovframework.itman.group.model.entity.ManageGroupFactory;
import egovframework.itman.state.dto.StateDto;

import java.util.Optional;

public class StateFactory {
    public static State toEntity(StateDto.Request dto) {
        return State.builder()
                .stateSeq(dto.getSeq())
                .stateName(dto.getName())
                .group(ManageGroupFactory.toCompactEntity(dto.getGroupSeq()))
                .tagColor(dto.getDescription())
                .enabled(Optional.ofNullable(dto.getEnabled()).orElse(true))
                .del(Optional.ofNullable(dto.getDel()).orElse(false))
                .build();
    }

    public static StateDto.Response toDto(State state) {
        return StateDto.Response.builder()
                .seq(state.getStateSeq())
                .name(state.getStateName())
                .description(state.getTagColor())
                .enabled(state.getEnabled())
                .del(state.getDel())
                .createdDate(state.getCreatedDate())
                .modifiedDate(state.getLastModifiedDate())
                .build();
    }

    public static State toCompactEntity(Long stateSeq) {
        return State.builder()
                .stateSeq(stateSeq)
                .build();
    }
}

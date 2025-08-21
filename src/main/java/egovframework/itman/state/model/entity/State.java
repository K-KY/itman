package egovframework.itman.state.model.entity;

import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.state.dto.StateDto;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class State extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateSeq;

    private String stateName;

    private String tagColor;

    private Boolean enabled;

    private Boolean del;

    @JoinColumn(name = "grp_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private ManageGroup group;

    public void change(StateDto.Request stateDto) {
        this.stateName = stateDto.getName();
        this.tagColor = stateDto.getDescription();
        this.enabled = Optional.ofNullable(stateDto.getEnabled()).orElse(true);
        this.del = Optional.ofNullable(stateDto.getDel()).orElse(false);
    }

    public void changeEnable(StateDto.Request stateDto) {
        this.enabled = Optional.ofNullable(stateDto.getEnabled()).orElse(true);
    }
}

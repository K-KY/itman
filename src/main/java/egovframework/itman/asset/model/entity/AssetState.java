package egovframework.itman.asset.model.entity;

import egovframework.itman.state.model.entity.State;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetState extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetStateId;

    @JoinColumn(name = "state_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private State state;

    private Boolean del;
}

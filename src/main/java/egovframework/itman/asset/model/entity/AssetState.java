package egovframework.itman.asset.model.entity;

import egovframework.itman.group.model.entity.ManageGroup;
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

    private String stateName;

    private String tagColor;

    private Boolean enabled;

    @JoinColumn(name = "grp_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private ManageGroup group;
}

package egovframework.itman.category.model.entity;

import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorySeq;

    @Column(unique = true)
    private String categoryName;

    private String tagColor;

    private Boolean enabled;

    private Boolean del;

    @JoinColumn(name = "grp_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private ManageGroup group;
}

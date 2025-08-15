package egovframework.itman.asset.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import egovframework.itman.category.model.entity.Category;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetCategorySeq;

    @JoinColumn(name = "category_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_seq")
    @JsonBackReference
    private Asset asset;

    private Boolean del;
}

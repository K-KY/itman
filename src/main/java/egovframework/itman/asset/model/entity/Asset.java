package egovframework.itman.asset.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Asset extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetSeq;

    private String serialNumber;

    @Column
    private String assetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grp_seq")
    private ManageGroup group;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AssetCategory> categories = new ArrayList<>();

    private String location;

    private LocalDateTime acqDate;

    private Boolean enabled;
    private Boolean del;

    public Asset change(AssetDto.Request assetDto) {
        this.assetName = assetDto.getAssetName();
        this.serialNumber = assetDto.getSerialNumber();
        this.acqDate = assetDto.getAcqDate();
        this.enabled = assetDto.getEnabled();
        this.location = assetDto.getLocation();
        this.categories = assetDto.getCategories().stream()
                .map(ac -> AssetFactory.toEntity(ac, this)).collect(Collectors.toList());
        this.del = Optional.ofNullable(assetDto.getDel()).orElse(false);
        return this;
    }


    //자산 이미지
    //자산 일련 번호 -> 생성조건 고민
    //자산 명
    //자산 분류 -> 다른 테이블로 분리
    //자산 상태 -> 다른 테이블로 관리
    //사용 직원 -> 교차 테이블로 분리
    //자산 위치 -> 다른 테이블로 관리
    //구매처 -> 다른 테이블로 관리
    //최초 구매일
    //가격
}

package egovframework.itman.asset.model.entity;

import egovframework.itman.asset.dto.AssetCategoryDto;
import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.category.model.entity.CategoryFactory;
import egovframework.itman.group.model.entity.ManageGroupFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssetFactory {

    /**
     * 자산
     * 카테로리고 OneToMany로 매핑 되어있으나 이 시점에는 저장하지 않음
     */
    public static Asset toEntity(AssetDto.Request assetDto) {
        return Asset.builder()
                .serialNumber(assetDto.getSerialNumber())
                .assetName(assetDto.getAssetName())
                .group(ManageGroupFactory.toCompactEntity(assetDto.getGroupSeq()))
                .location(assetDto.getLocation())
                .acqDate(assetDto.getAcqDate())
                .enabled(assetDto.getEnabled())
                .build();
    }

    public static Asset toCompactEntity(Long assetSeq) {
        return Asset.builder()
                .assetSeq(assetSeq)
                .build();
    }

    public static AssetDto.Response toDto(Asset asset) {
        System.out.println("asset.getCategories().get(0) = " + asset.getCategories());
        return AssetDto.Response.builder()
                .assetSeq(asset.getAssetSeq())
                .serialNumber(asset.getSerialNumber())
                .assetName(asset.getAssetName())
                .location(asset.getLocation())
                .acqDate(asset.getAcqDate())
                .enabled(asset.getEnabled())
                .categories(
                        asset.getCategories().stream()
                                .map(AssetFactory::toDto)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static AssetCategory toEntity(AssetCategoryDto.Request assetCategoryDto, Asset asset) {
        return AssetCategory.builder()
                .assetCategorySeq(assetCategoryDto.getAssetCategorySeq())//자산 카테고리 번호 새로 생성하는경우 null
                .category(CategoryFactory.toCompactEntity(assetCategoryDto.getCategorySeq()))//부모 카테고리
                .asset(toCompactEntity(assetCategoryDto.getAssetSeq()))
                .del(Optional.ofNullable(assetCategoryDto.getDel()).orElse(false))
                .asset(asset)
                .build();
    }

    public static AssetCategoryDto.Response toDto(AssetCategory assetCategory) {
        return AssetCategoryDto.Response.builder()
                .assetCategorySeq(assetCategory.getAssetCategorySeq())
                .category(CategoryFactory.toDto(assetCategory.getCategory()))
                .createdDate(assetCategory.getCreatedDate())
                .modifiedDate(assetCategory.getLastModifiedDate())
                .del(assetCategory.getDel())
                .build();
    }


    /**
     *
     * @param asset
     * @param assetCategories
     * @Return
     *  Long assetSeq<br/>
     *  String serialNumber<br/>
     *  String assetName<br/>
     *  String location<br/>
     *  Boolean enabled<br/>
     *
     *  List<AssetCategoryDto.Response> categories<br/>
     *
     *  LocalDateTime acqDate<br/>
     *  LocalDateTime createdDate<br/>
     *  LocalDateTime modifiedDate<br/>
     */
    public static AssetDto.Response toDto(Asset asset, List<AssetCategory> assetCategories) {
        return AssetDto.Response.builder()
                .assetSeq(asset.getAssetSeq())
                .serialNumber(asset.getSerialNumber())
                .assetName(asset.getAssetName())
                .location(asset.getLocation())
                .enabled(asset.getEnabled())
                .categories(
                        assetCategories.stream()
                                .map(AssetFactory::toDto)
                                .collect(Collectors.toList())
                )
                .acqDate(asset.getAcqDate())
                .createdDate(asset.getCreatedDate())
                .modifiedDate(asset.getLastModifiedDate())
                .build();
    }
}

package egovframework.itman.asset.controller;

import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.asset.model.entity.Asset;
import egovframework.itman.asset.model.entity.AssetCategory;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.service.interfaces.AssetCategoryService;
import egovframework.itman.asset.model.service.interfaces.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;
    private final AssetCategoryService assetCategoryService;


    @GetMapping
    public Page<AssetDto.Response> read(Pageable pageable) {
        return assetService.read(pageable).map(AssetFactory::toDto);
    }

    @PostMapping
    public AssetDto.Response create(@RequestBody AssetDto.Request assetDto) {
        Asset asset = assetService.create(assetDto);//자산 먼저 저장
        List<AssetCategory> assetCategories = assetCategoryService.create(assetDto.getCategories(), asset);//그후 카테고리
        return AssetFactory.toDto(asset, assetCategories);//둘이 dto로 만들어서 반환
    }

    @PatchMapping
    public AssetDto.Response update(@RequestBody AssetDto.Request assetDto) {
        return AssetFactory.toDto(assetService.update(assetDto));
    }
}

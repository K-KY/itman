package egovframework.itman.asset.controller;

import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.asset.model.entity.Asset;
import egovframework.itman.asset.model.entity.AssetCategory;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.service.interfaces.AssetCategoryService;
import egovframework.itman.asset.model.service.interfaces.AssetService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;
    private final AssetCategoryService assetCategoryService;


    @GetMapping
    public Page<AssetDto.Response> read(int page, int size, Long groupSeq, SortDto sort) {
        PageRequest pageable = PageRequest.of(page - 1, size, sort.getSorts());
        return assetService.readEnabled(pageable, groupSeq).map(AssetFactory::toDto);
    }

    @GetMapping("detail")
    public AssetDto.Response readDetail(Long assetSeq, Long groupSeq) {
        return AssetFactory.toDto(assetService.read(assetSeq, groupSeq));
    }

    @PostMapping
    public AssetDto.Response create(@RequestBody AssetDto.Request assetDto) {
        if (assetDto.getGroupSeq() == null) {
            throw new IllegalArgumentException("그룹 번호 필수입니다.");
        }
        Asset asset = assetService.create(assetDto);//자산 먼저 저장
        List<AssetCategory> assetCategories = assetCategoryService.create(assetDto.getCategories(), asset);//그후 카테고리
        return AssetFactory.toDto(asset, assetCategories);//둘이 dto로 만들어서 반환
    }

    @PatchMapping
    public AssetDto.Response update(@RequestBody AssetDto.Request assetDto) {
        return AssetFactory.toDto(assetService.update(assetDto));
    }

    @GetMapping("/keyword")
    public Page<AssetDto.Response> readKeyword(int page, int size, Long groupSeq, String keyword, SortDto sort) {
        PageRequest pageable = PageRequest.of(page - 1, size, sort.getSorts());
        return assetService.read(pageable, groupSeq, keyword).map(AssetFactory::toDto);
    }
}

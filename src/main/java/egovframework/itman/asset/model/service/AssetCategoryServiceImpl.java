package egovframework.itman.asset.model.service;

import egovframework.itman.asset.dto.AssetCategoryDto;
import egovframework.itman.asset.model.entity.Asset;
import egovframework.itman.asset.model.entity.AssetCategory;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.repository.AssetCategoryRepository;
import egovframework.itman.asset.model.service.interfaces.AssetCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetCategoryServiceImpl implements AssetCategoryService {

    private final AssetCategoryRepository assetCategoryRepository;
    @Override
    public List<AssetCategory> create(List<AssetCategoryDto.Request> categories, Asset asset) {
        List<AssetCategory> collect = categories
                .stream()
                .map(ac -> AssetFactory.toEntity(ac, asset))
                .collect(Collectors.toList());
        return assetCategoryRepository.saveAll(collect);
    }
}

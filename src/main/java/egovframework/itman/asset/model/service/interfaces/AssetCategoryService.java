package egovframework.itman.asset.model.service.interfaces;

import egovframework.itman.asset.dto.AssetCategoryDto;
import egovframework.itman.asset.model.entity.Asset;
import egovframework.itman.asset.model.entity.AssetCategory;
import egovframework.itman.util.dto.SortDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AssetCategoryService {
    List<AssetCategory> create(List<AssetCategoryDto.Request> categories, Asset asset);

    Page<AssetCategory> readAll(int page, int size, SortDto sort, Long groupSeq);


}

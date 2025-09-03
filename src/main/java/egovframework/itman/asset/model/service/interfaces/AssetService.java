package egovframework.itman.asset.model.service.interfaces;

import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.asset.model.entity.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssetService {
    Asset create(AssetDto.Request assetDto);

    Page<Asset> read(Pageable pageable);
    Page<Asset> readEnabled(Pageable pageable, Long groupSeq);
    Page<Asset> readDeleted(Pageable pageable, Long groupSeq);

    Asset update(AssetDto.Request assetDto);

    Asset read(Long assetSeq, Long groupSeq);
}

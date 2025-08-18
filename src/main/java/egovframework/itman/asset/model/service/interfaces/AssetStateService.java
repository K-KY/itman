package egovframework.itman.asset.model.service.interfaces;

import egovframework.itman.asset.dto.AssetStateDto;
import egovframework.itman.asset.model.entity.AssetState;
import egovframework.itman.util.dto.SortDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssetStateService {
    Page<AssetState> read(Pageable pageable, Long groupSeq, SortDto sort);

    AssetStateDto.Response create(AssetStateDto.Request assetStateDto);
}

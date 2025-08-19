package egovframework.itman.asset.model.service;

import egovframework.itman.asset.dto.AssetStateDto;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.entity.AssetState;
import egovframework.itman.asset.model.repository.AssetStateRepository;
import egovframework.itman.asset.model.service.interfaces.AssetStateService;
import egovframework.itman.util.dto.SortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetStateServiceImpl implements AssetStateService {

    private final AssetStateRepository assetStateRepository;

    @Override
    public Page<AssetState> read(Pageable pageable, Long groupSeq, SortDto sort) {
        return assetStateRepository.findAllByDelFalseAndState_Group_GroupSeq(pageable, groupSeq);
    }

    @Override
    public AssetState create(AssetStateDto.Request assetStateDto) {
        return assetStateRepository.save(AssetFactory.toEntity(assetStateDto));
    }

    @Override
    public AssetState update(AssetStateDto.Request request) {
        AssetState assetState = assetStateRepository.findByAssetStateSeq(request.getAssetStateId());
        assetState.change(request);
        return assetState;
    }
}
package egovframework.itman.asset.model.service;

import egovframework.itman.asset.dto.AssetDto;
import egovframework.itman.asset.model.entity.Asset;
import egovframework.itman.asset.model.entity.AssetFactory;
import egovframework.itman.asset.model.repository.AssetRepository;
import egovframework.itman.asset.model.service.interfaces.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Override
    @Transactional
    public Asset create(AssetDto.Request assetDto) {
        return assetRepository.save(AssetFactory.toEntity(assetDto));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asset> readEnabled(Pageable pageable, Long groupSeq) {
        return assetRepository.findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(pageable, groupSeq);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asset> read(Pageable pageable) {
        return assetRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asset> readDeleted(Pageable pageable, Long groupSeq) {
        return assetRepository.findAllByDelTrue(pageable, groupSeq);
    }

    @Override
    @Transactional
    public Asset update(AssetDto.Request assetDto) {
        Asset asset = assetRepository.findByAssetSeq(assetDto.getAssetSeq());
        asset = asset.change(assetDto);
        assetRepository.save(asset);
        return asset;
    }

    @Override
    public Asset read(Long assetSeq, Long groupSeq) {
        return assetRepository.findByAssetSeqAndGroup_GroupSeq(assetSeq, groupSeq);
    }
}

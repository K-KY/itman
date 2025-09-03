package egovframework.itman.asset.model.repository;

import egovframework.itman.asset.model.entity.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    @EntityGraph(attributePaths = {"categories"})
    Page<Asset> findAll(Pageable pageable);

    Asset findByAssetSeq(Long assetSeq);

    Page<Asset> findAllByEnabledTrueAndGroup_GroupSeq(Pageable pageable, Long groupSeq);

    Page<Asset> findAllByDelTrue(Pageable pageable, Long groupSeq);

    Page<Asset> findAllByEnabledTrueAndDelFalseAndGroup_GroupSeq(Pageable pageable, Long groupSeq);

    Asset findByAssetSeqAndGroup_GroupSeq(Long assetSeq, Long groupGroupSeq);
}

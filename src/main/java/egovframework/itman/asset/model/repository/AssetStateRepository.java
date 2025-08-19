package egovframework.itman.asset.model.repository;

import egovframework.itman.asset.model.entity.AssetState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetStateRepository extends JpaRepository<AssetState, Long> {
    Page<AssetState> findAllByDelFalseAndState_Group_GroupSeq(Pageable pageable, Long groupSeq);

    AssetState findByAssetStateSeq(Long assetStateSeq);
}

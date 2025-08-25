package egovframework.itman.asset.model.repository;

import egovframework.itman.asset.model.entity.AssetCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Long> {
    Page<AssetCategory> findAllByCategory_GroupGroupSeq(Pageable pageable, Long groupSeq);
}

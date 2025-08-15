package egovframework.itman.asset.model.repository;

import egovframework.itman.asset.model.entity.AssetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Long> {
}

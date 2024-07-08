package com.Value.VGREEN.Repository;

import com.Value.VGREEN.Entity.FixedAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedAssetsRepository extends JpaRepository<FixedAssets, Integer> {

}

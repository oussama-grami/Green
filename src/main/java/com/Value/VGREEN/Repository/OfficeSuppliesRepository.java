package com.Value.VGREEN.Repository;

import com.Value.VGREEN.Entity.OfficeSupplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeSuppliesRepository extends JpaRepository<OfficeSupplies, Integer> {
}

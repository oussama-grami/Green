package com.Value.VGREEN.Repository;

import com.Value.VGREEN.Entity.Freight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Integer> {
}

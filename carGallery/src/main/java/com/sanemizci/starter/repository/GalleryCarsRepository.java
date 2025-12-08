package com.sanemizci.starter.repository;

import com.sanemizci.starter.model.GalleryCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryCarsRepository extends JpaRepository<GalleryCars,Long> {
}

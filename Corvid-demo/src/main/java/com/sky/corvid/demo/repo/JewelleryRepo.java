package com.sky.corvid.demo.repo;

import com.sky.corvid.demo.domain.Jewellery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelleryRepo extends JpaRepository<Jewellery, Integer> {
}

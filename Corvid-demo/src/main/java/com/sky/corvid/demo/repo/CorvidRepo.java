package com.sky.corvid.demo.repo;

import com.sky.corvid.demo.domain.Corvid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorvidRepo extends JpaRepository<Corvid, Integer> {

    Corvid getCorvidBySpeciesIgnoreCase(String species);

}

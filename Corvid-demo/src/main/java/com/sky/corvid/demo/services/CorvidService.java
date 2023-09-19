package com.sky.corvid.demo.services;

import com.sky.corvid.demo.domain.Corvid;

import java.util.List;

public interface CorvidService {

    Corvid createCorvid(Corvid c);

    Corvid getCorvid(int id);

    Corvid getCorvidBySpecies(String species);

    List<Corvid> getAll();

    Corvid updateCorvid(
            Integer id,
            String species,
            Integer weight,
            String colours);

    String removeCorvid(int id);


}

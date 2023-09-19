package com.sky.corvid.demo.services;

import com.sky.corvid.demo.domain.Corvid;
import com.sky.corvid.demo.repo.CorvidRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary // tells Spring to use this service over CorvidServiceList
public class CorvidServiceDB implements CorvidService {

    private CorvidRepo repo;
    // injecting repo into service through a constructor
    public CorvidServiceDB (CorvidRepo repo){
        this.repo = repo;
    }

    @Override
    public Corvid createCorvid(Corvid c) {
        return this.repo.save(c);
    }

    @Override
    public Corvid getCorvid(int id) {
        Optional<Corvid> found = this.repo.findById(id);
        return found.get();
    }

    public Corvid getCorvidBySpecies(String species){
        return this.repo.getCorvidBySpeciesIgnoreCase(species);
    }

    @Override
    public List<Corvid> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Corvid updateCorvid(Integer id, String species, Integer weight, String colours) {
        Corvid toUpdate = this.getCorvid(id);
        if (species != null) toUpdate.setSpecies(species);
        if (weight != null) toUpdate.setWeight(weight);
        if (colours != null) toUpdate.setColours(colours);
        return this.repo.save(toUpdate);
    }

    @Override
    public String removeCorvid(int id) {
        if (this.repo.existsById(id)){
            String toDelete = this.repo.findById(id).get().getSpecies();
            this.repo.deleteById(id);
            return "Corvid removed: " + toDelete;
        } else {
            return "NOT FOUND";
        }
    }

}

package com.sky.corvid.demo.services;

import com.sky.corvid.demo.domain.Corvid;
import com.sky.corvid.demo.rest.CorvidController;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorvidServiceList implements CorvidService {

    private List<Corvid> corvidae = new ArrayList<>();

    @Override
    public Corvid createCorvid(Corvid c) {
        corvidae.add(c);
        Corvid created = corvidae.get(this.corvidae.size() - 1);
        return created;
    }

    @Override
    public Corvid getCorvid(int id) {
        if (id < this.corvidae.size())
            return this.corvidae.get(id);
        else
            return null;
    }

    @Override
    public Corvid getCorvidBySpecies(String species) {
        return null;
    }

    @Override
    public List<Corvid> getAll() {
        return this.corvidae;
    }

    @Override
    public Corvid updateCorvid(Integer id, String species, Integer weight, String colours) {

        if (id >= this.corvidae.size()) return null;

        Corvid toUpdate = this.corvidae.get(id);

        if (species != null) toUpdate.setSpecies(species);
        if (weight != null) toUpdate.setWeight(weight);
        if (colours != null) toUpdate.setColours(colours);

        return toUpdate;
    }

    @Override
    public String removeCorvid(int id) {
        if (id >= this.corvidae.size()) return "NOT FOUND";
        else {
            String toDelete = this.corvidae.get(id).getSpecies();
            this.corvidae.remove(id);
            return "Corvid removed: " + toDelete;
        }
    }
}

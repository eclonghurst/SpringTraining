package com.sky.corvid.demo.services;

import com.sky.corvid.demo.domain.Jewellery;
import com.sky.corvid.demo.repo.JewelleryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelleryService {

    private JewelleryRepo repo;

    public JewelleryService(JewelleryRepo repo) {
        this.repo = repo;
    }

    public Jewellery createJewellery(Jewellery j){
        return this.repo.save(j);
    }

    public List<Jewellery> getAllJewellery(){
        return this.repo.findAll();
    }

    public String removeJewellery(int id) {
        if (this.repo.existsById(id)){
            String toDelete = this.repo.findById(id).get().getName();
            this.repo.deleteById(id);
            return "Jewellery removed: " + toDelete;
        } else {
            return "NOT FOUND";
        }
    }

}

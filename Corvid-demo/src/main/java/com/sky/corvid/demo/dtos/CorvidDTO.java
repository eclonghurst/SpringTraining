package com.sky.corvid.demo.dtos;

import com.sky.corvid.demo.domain.Corvid;
import com.sky.corvid.demo.domain.Jewellery;

import java.util.ArrayList;
import java.util.List;

public class CorvidDTO {

    private Integer id;
    private String species;
    private int weight;
    private String colours;

    private List<JewelleryDTO> jewelleryList;

    public CorvidDTO(Corvid c) {
        this.id = c.getId();
        this.species = c.getSpecies();
        this.weight = c.getWeight();
        this.colours = c.getColours();
        List<JewelleryDTO> dtos = new ArrayList<>();
        for(Jewellery j: c.getJewellery())
            dtos.add(new JewelleryDTO(j));
        this.jewelleryList = dtos;
    }

    public CorvidDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColours() {
        return colours;
    }

    public void setColours(String colours) {
        this.colours = colours;
    }

    public List<JewelleryDTO> getJewelleryList() {
        return jewelleryList;
    }

    public void setJewelleryList(List<JewelleryDTO> jewelleryList) {
        this.jewelleryList = jewelleryList;
    }
}

package com.sky.corvid.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // tells Spring this class is linked to a table
public class Corvid {
    @Id // marks the field as a unique identifier (Primary Key)
    // sets the field to AUTO_INCREMENT (id starts at 1 and goes up by one each new record)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String species;
    private  Integer weight;
    private String colours;


    public Corvid(String species, int weight, String colours){
        super();
        this.species = species;
        this.weight = weight;
        this.colours = colours;
    }

    //  Required for this to work
    public Corvid(){
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColours() {
        return colours;
    }

    public void setColours(String colours) {
        this.colours = colours;
    }
}

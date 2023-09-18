package com.sky.corvid.demo.domain;

public class Corvid {

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

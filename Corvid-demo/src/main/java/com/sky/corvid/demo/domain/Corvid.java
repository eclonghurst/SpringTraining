package com.sky.corvid.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity // tells Spring this class is linked to a table
public class Corvid {
    @Id // marks the field as a unique identifier (Primary Key)
    // sets the field to AUTO_INCREMENT (id starts at 1 and goes up by one each new record)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String species;
    private  Integer weight;
    private String colours;

    //Bidirectional relationship
    @OneToMany(mappedBy = "owner")
    private List<Jewellery> jewelleryList;


    public Corvid(String species, int weight, String colours){
        super();
        this.species = species;
        this.weight = weight;
        this.colours = colours;
    }

    public Corvid(Integer id, String species, Integer weight, String colours) {
        this.id = id;
        this.species = species;
        this.weight = weight;
        this.colours = colours;
    }

    //  Required for this to work
    public Corvid(){
        super();
    }

    public List<Jewellery> getJewellery() {
        return jewelleryList;
    }

    public void setJewelleryList(List<Jewellery> jewelleryList) {
        this.jewelleryList = jewelleryList;
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

    @Override
    public String toString() {
        return "Corvid{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", colours='" + colours + '\'' +
                '}';
    }

    // Needed for mockito equals testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corvid corvid = (Corvid) o;
        return Objects.equals(id, corvid.id) && Objects.equals(species, corvid.species) && Objects.equals(weight, corvid.weight) && Objects.equals(colours, corvid.colours) && Objects.equals(jewelleryList, corvid.jewelleryList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, species, weight, colours, jewelleryList);
    }
}
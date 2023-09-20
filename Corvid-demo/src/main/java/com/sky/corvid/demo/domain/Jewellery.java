package com.sky.corvid.demo.domain;

import javax.persistence.*;

@Entity
public class Jewellery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String gem;

    // Unidirectional relationship
    @ManyToOne
    private Corvid owner;

    public Jewellery(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGem() {
        return gem;
    }

    public void setGem(String gem) {
        this.gem = gem;
    }

    public Corvid getOwner() {
        return owner;
    }

    public void setOwner(Corvid owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Jewellery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gem='" + gem + '\'' +
                ", owner=" + owner +
                '}';
    }
}

package com.sky.corvid.demo.dtos;

import com.sky.corvid.demo.domain.Jewellery;

public class JewelleryDTO {

    private int id;
    private String name;
    private String gem;

    private Integer ownerId;

    public JewelleryDTO(Jewellery j) {
        this.id = j.getId();
        this.name = j.getName();
        this.gem = j.getGem();
        if(j.getOwner()!=null)
            this.ownerId = j.getOwner().getId();
    }

    public JewelleryDTO() {
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}

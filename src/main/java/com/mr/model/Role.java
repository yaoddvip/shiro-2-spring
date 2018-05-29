package com.mr.model;

public class Role {
    private Long id;

    private String name;

    private String sn;

    public Role(Long id, String name, String sn) {
        this.id = id;
        this.name = name;
        this.sn = sn;
    }

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }
}
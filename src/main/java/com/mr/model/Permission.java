package com.mr.model;

public class Permission {
    private Long id;

    private String name;

    private String resource;

    public Permission(Long id, String name, String resource) {
        this.id = id;
        this.name = name;
        this.resource = resource;
    }

    public Permission() {
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }
}
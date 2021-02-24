package com.example.teabackend.entities;

import java.util.UUID;

public class Condition {

    private UUID id;
    private String name;
    private String description;


    public Condition(ConditionEntity conditionEntity) {
        this.id = conditionEntity.getId();
        this.name = conditionEntity.getName();
        this.description = conditionEntity.getDescription();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

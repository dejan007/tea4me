package com.example.teabackend.entities;

import com.example.teabackend.entities.TeaEntity;

import java.util.UUID;

public class Tea {

    private UUID id;
    private String name;
    private String description;
    private byte[] image;


    public Tea(TeaEntity teaEntity) {
        this.id = teaEntity.getId();
        this.name = teaEntity.getName();
        this.description = teaEntity.getDescription();
        this.image = teaEntity.getImage();
    }

    public Tea() {
    }

    public static Tea mapEntityToDto(TeaEntity teaEntity) {
        Tea tea = new Tea();
        tea.setId(teaEntity.getId());
        tea.setName(teaEntity.getName());
        tea.setDescription(teaEntity.getDescription());
        tea.setImage(teaEntity.getImage());

        return tea;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

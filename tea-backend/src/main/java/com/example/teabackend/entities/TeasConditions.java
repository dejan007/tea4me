package com.example.teabackend.entities;

import java.util.UUID;

public class TeasConditions {

    private UUID id;
    private UUID teaId;
    private UUID conditionId;

    public TeasConditions(UUID id, UUID teaId, UUID conditionId) {
        this.id = id;
        this.teaId = teaId;
        this.conditionId = conditionId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTeaId() {
        return teaId;
    }

    public void setTeaId(UUID teaId) {
        this.teaId = teaId;
    }

    public UUID getConditionId() {
        return conditionId;
    }

    public void setConditionId(UUID conditionId) {
        this.conditionId = conditionId;
    }
}

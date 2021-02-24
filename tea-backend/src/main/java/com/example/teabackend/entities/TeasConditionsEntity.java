package com.example.teabackend.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="teatocondition")
@NamedQuery(name="TeasConditionsEntity.findAll", query="SELECT e FROM TeasConditionsEntity e")
public class TeasConditionsEntity {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Type(type="uuid-char")
    @Column(name = "tea_id")
    private UUID teaId;

    @Type(type="uuid-char")
    @Column(name = "condition_id")
    private UUID conditionId;

    public TeasConditionsEntity(){}

    public TeasConditionsEntity(UUID id, UUID teaId, UUID conditionId) {
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

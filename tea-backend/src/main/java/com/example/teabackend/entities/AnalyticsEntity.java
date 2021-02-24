package com.example.teabackend.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "analytics")
@NamedQuery(name="AnalyticsEntity.findAll", query="SELECT e FROM AnalyticsEntity e")
public class AnalyticsEntity implements Serializable {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name= "created_at")
    private Timestamp timestamp;

    @Type(type="uuid-char")
    @Column(name= "condition_id")
    private UUID conditionId;

    public AnalyticsEntity(){}

    public AnalyticsEntity(Timestamp timestamp, UUID conditionId) {

        this.timestamp = timestamp;
        this.conditionId = conditionId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getConditionId() {
        return conditionId;
    }

    public void setConditionId(UUID conditionId) {
        this.conditionId = conditionId;
    }
}

package com.example.teabackend.entities;


import java.sql.Timestamp;
import java.util.UUID;

public class Analytics {

    private UUID id;
    private Timestamp timestamp;
    private UUID condition_id;

    public static Analytics mapEntityToDto(AnalyticsEntity entity) {
        Analytics analytics = new Analytics();
        analytics.setId(entity.getId());
        analytics.setTimestamp(entity.getTimestamp());
        analytics.setCondition_id(entity.getConditionId());

        return analytics;
    }

    public Analytics(){}

    public Analytics(Timestamp timestamp, UUID condition_id) {
        this.timestamp = timestamp;
        this.condition_id =condition_id;
    }

    public Analytics(UUID id, Timestamp timestamp, UUID condition_id) {
        this.id = id;
        this.timestamp = timestamp;
        this.condition_id = condition_id;
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

    public UUID getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(UUID condition_id) {
        this.condition_id = condition_id;
    }
}

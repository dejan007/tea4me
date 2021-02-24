package com.example.teabackend.repositorys;


import com.example.teabackend.entities.AnalyticsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudAnalyticsRepository extends CrudRepository<AnalyticsEntity, UUID> {
}

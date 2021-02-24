package com.example.teabackend.repositorys;

import com.example.teabackend.entities.ConditionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudConditionRepository extends CrudRepository<ConditionEntity, UUID> {
}

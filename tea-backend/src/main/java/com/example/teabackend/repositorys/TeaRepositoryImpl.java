package com.example.teabackend.repositorys;

import com.example.teabackend.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeaRepositoryImpl implements TeaRepository {

    @Autowired
    CrudTeaRepository crudTeaRepository;

    @Autowired
    CrudConditionRepository crudConditionRepository;

    @Autowired
    CrudAnalyticsRepository crudAnalyticsRepository;

    @Override
    public List<Condition> getAllConditions() {
        List<Condition> listOfConditions = new ArrayList<>();

        for (ConditionEntity e: crudConditionRepository.findAll()) {
            listOfConditions.add(new Condition(e));
        }
        return listOfConditions;
    }


    @Override
    public List<Tea> getTeas(List<String> listOfConditionIds) {

        // All teas that cover at least one condition
        List<UUID> listOfTeaIds = crudTeaRepository.getListOfTeaIds(listOfConditionIds);
        saveAnalitics(listOfConditionIds);
        return findMatchingTeas(listOfConditionIds, listOfTeaIds);
    }

    private List<Tea> findMatchingTeas(List<String> listOfConditionIds, List<UUID> listOfTeaIds) {
        List <UUID> listOfResultTeasIds = new ArrayList<>();

        // Filter only teas that cover all conditions
        for (UUID id:listOfTeaIds) {
            if (crudTeaRepository.getListOfConditionsForOneTea(id.toString()).containsAll(listOfConditionIds)) {
                listOfResultTeasIds.add(id);
            }
        }

        // Fetch teaEntities that match the conditions
        List<TeaEntity> listOfTeaEntities = new ArrayList<>();
        listOfResultTeasIds.forEach(id -> listOfTeaEntities.add(crudTeaRepository.findById(id).orElse(null)));

        return listOfTeaEntities.stream().map(Tea::mapEntityToDto).collect(Collectors.toList());
    }

    private void saveAnalitics(List<String> listOfConditionIds) {

            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

            AnalyticsEntity entity = new AnalyticsEntity(currentTimestamp,
                    UUID.fromString(listOfConditionIds.get(listOfConditionIds.size()-1)));
            crudAnalyticsRepository.save(entity);



    }
}

package com.example.teabackend.repositorys;

import com.example.teabackend.entities.TeaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CrudTeaRepository extends CrudRepository<TeaEntity, UUID> {

    @Query(value= "SELECT id FROM teas.tea where id IN (select teas.teatocondition.tea_id from teas.teatocondition where condition_id in :conditionIds)", nativeQuery = true)
    List<UUID> getListOfTeaIds(@Param("conditionIds") List<String> conditionIds);

    @Query(value= "SELECT condition_id FROM teas.teatocondition where tea_id=:teaId", nativeQuery = true)
    List<String> getListOfConditionsForOneTea(@Param("teaId") String teaId);
}

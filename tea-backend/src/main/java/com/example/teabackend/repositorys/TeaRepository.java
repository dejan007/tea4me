package com.example.teabackend.repositorys;

import com.example.teabackend.entities.Condition;
import com.example.teabackend.entities.Tea;
import com.example.teabackend.entities.TeaEntity;

import java.util.List;
import java.util.Optional;

public interface TeaRepository {

    List<Condition> getAllConditions();

    List<Tea> getTeas(List<String> listOfIds);
}

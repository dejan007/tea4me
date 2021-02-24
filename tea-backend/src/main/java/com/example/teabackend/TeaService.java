package com.example.teabackend;

import com.example.teabackend.entities.Condition;
import com.example.teabackend.entities.Tea;

import java.util.List;

public interface TeaService {


    List<Condition> getAllConditions();



    List<Tea> getTeas(List<String> listOfIds);
}

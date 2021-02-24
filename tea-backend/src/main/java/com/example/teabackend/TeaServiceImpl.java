package com.example.teabackend;

import com.example.teabackend.entities.Condition;
import com.example.teabackend.entities.Tea;
import com.example.teabackend.repositorys.TeaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TeaServiceImpl implements TeaService {
    TeaRepository teaRepository;

    public TeaServiceImpl ( TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }


    @Override
    public List<Condition> getAllConditions() {
        List<Condition> listOfConditions = teaRepository.getAllConditions();
        listOfConditions.sort(Comparator.comparing(Condition::getName));
        return listOfConditions;
    }


    @Override
    public List<Tea> getTeas(List<String> listOfIds) {
        return teaRepository.getTeas(listOfIds);
    }
}


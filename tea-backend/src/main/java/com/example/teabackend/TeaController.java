package com.example.teabackend;

import com.example.teabackend.entities.Condition;
import com.example.teabackend.entities.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TeaController {

    @Autowired
    TeaService teaService;

    @CrossOrigin(origins = ("http://localhost:3000"))
    @PostMapping("/get-teas")
    public List<Tea> getTeas(@RequestBody String[] listOfIdsString) {
        return teaService.getTeas(Arrays.asList(listOfIdsString));
    }

    @CrossOrigin(origins =("http://localhost:3000"))
    @GetMapping("/conditions")
    public List<Condition> getAllConditions() {
        return teaService.getAllConditions();
    }

}

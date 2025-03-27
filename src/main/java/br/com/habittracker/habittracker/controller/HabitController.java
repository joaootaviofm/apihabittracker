package br.com.habittracker.habittracker.controller;

import br.com.habittracker.habittracker.service.HabitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HabitController {

    HabitService habitService;
    HabitController(HabitService habitService){
        this.habitService = habitService;
    }

}

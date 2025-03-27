package br.com.habittracker.habittracker.controller;

import br.com.habittracker.habittracker.model.Habit;
import br.com.habittracker.habittracker.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    HabitService habitService;
    HabitController(HabitService habitService){
        this.habitService = habitService;
    }


    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody HabitDTO habitDTO){

        var userId = habitService.createHabit(habitDTO);
        return ResponseEntity.created(URI.create("/habits/"+ userId.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> getHabitById(@PathVariable("id") Long id){

        var user = habitService.getHabitById(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Habit>> getAllHabits(){

        return ResponseEntity.ok(habitService.getAllHabits());

    }
}

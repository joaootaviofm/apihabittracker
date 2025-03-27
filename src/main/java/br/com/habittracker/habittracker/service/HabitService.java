package br.com.habittracker.habittracker.service;


import br.com.habittracker.habittracker.controller.CreateHabitDTO;
import br.com.habittracker.habittracker.model.Habit;
import br.com.habittracker.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    HabitRepository habitRepository;
    HabitService(HabitRepository habitRepository){
        this.habitRepository = habitRepository;
    }

    public Long createHabit(CreateHabitDTO createHabitDTO){
        var entity = new Habit(
            null,
            createHabitDTO.habit(),
            createHabitDTO.description(),
            createHabitDTO.isComplete());

        var userSaved = habitRepository.save(entity);
        return userSaved.getId();
    }

    public Optional<Habit> getHabitById(Long id){
        return habitRepository.findById(id);
    }

    public List<Habit> getAllHabits(){
        return habitRepository.findAll();
    }

    public void deleteHabitById(Long id){
        habitRepository.deleteById(id);
    }
}

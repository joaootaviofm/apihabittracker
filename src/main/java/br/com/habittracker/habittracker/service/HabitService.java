package br.com.habittracker.habittracker.service;


import br.com.habittracker.habittracker.controller.HabitDTO;
import br.com.habittracker.habittracker.model.Habit;
import br.com.habittracker.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    HabitRepository habitRepository;
    HabitService(HabitRepository habitRepository){
        this.habitRepository = habitRepository;
    }

    public Long createHabit(HabitDTO habitDTO){

        var entity = new Habit(null,
                habitDTO.name(),
                habitDTO.description(),
                habitDTO.isComplete());
        var userSaved = habitRepository.save(entity);
        return userSaved.getId();
    }

}

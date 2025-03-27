package br.com.habittracker.habittracker.service;


import br.com.habittracker.habittracker.controller.CreateHabitDTO;
import br.com.habittracker.habittracker.controller.UpdateHabitDTO;
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


    public void updateHabit(Long id, UpdateHabitDTO updateHabitDTO){

        var habitEntity = habitRepository.findById(id);

        if(habitEntity.isPresent()){
            var habit = habitEntity.get();

            if(updateHabitDTO.habit() != null){
                habit.setHabit(updateHabitDTO.habit());
            }

            if (updateHabitDTO.description() != null){
                habit.setDescription(updateHabitDTO.description());
            }

            if(updateHabitDTO.isComplete() != null){
                habit.setIsComplete(updateHabitDTO.isComplete());
            }
            habitRepository.save(habit);
        }
    }

    public void deleteHabitById(Long id){
        habitRepository.deleteById(id);
    }
}

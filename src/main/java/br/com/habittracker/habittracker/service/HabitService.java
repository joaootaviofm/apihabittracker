package br.com.habittracker.habittracker.service;


import br.com.habittracker.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    HabitRepository repository;
    HabitService(HabitRepository repository){
        this.repository = repository;
    }

    
}

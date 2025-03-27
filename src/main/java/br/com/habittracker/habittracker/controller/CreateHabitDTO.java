package br.com.habittracker.habittracker.controller;

public record CreateHabitDTO(String habit, String description, Boolean isComplete) {
}

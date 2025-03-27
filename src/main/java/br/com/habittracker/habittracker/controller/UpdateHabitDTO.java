package br.com.habittracker.habittracker.controller;

public record UpdateHabitDTO(String habit, String description, Boolean isComplete) {
}

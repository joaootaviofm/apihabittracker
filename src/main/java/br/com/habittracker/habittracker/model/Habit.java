package br.com.habittracker.habittracker.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_habit")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "habit")
    private String habit;

    @Column(name = "description")
    private String description;

    @Column(name = "isComplete")
    private Boolean isComplete;
    
}

package com.example.ejerciciocinco.main.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ejerciciocinco.main.Model.Task;
import java.util.Optional;

@Repository
public interface ITask extends CrudRepository<Task, Integer>{
    
    public Optional<Task>  findAllById(int id);
}

package com.example.ejerciciocinco.main.InterfacesServices;

import java.util.List;
import java.util.Optional;

import com.example.ejerciciocinco.main.Model.Task;

public interface ITaskService {

    public List<Task> list();

    public Optional<Task> listId(int id);

    public int save(Task task);
    
    public void delete(int id);

    
}

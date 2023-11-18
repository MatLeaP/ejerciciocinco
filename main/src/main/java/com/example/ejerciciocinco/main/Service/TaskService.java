package com.example.ejerciciocinco.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejerciciocinco.main.Interfaces.ITask;
import com.example.ejerciciocinco.main.InterfacesServices.ITaskService;
import com.example.ejerciciocinco.main.Model.Task;


@Service
public class TaskService implements ITaskService {

    @Autowired
    ITask data;


    @Override
    public List<Task> list() {
        return (List<Task>) data.findAll();
    }

    @Override
    public Optional<Task> listId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Task task) {
        int res = 0;
        Task t = data.save(task);
        if(!t.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}

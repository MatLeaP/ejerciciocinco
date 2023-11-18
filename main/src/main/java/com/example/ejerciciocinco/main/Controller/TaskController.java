package com.example.ejerciciocinco.main.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejerciciocinco.main.Model.Task;
import com.example.ejerciciocinco.main.Service.TaskService;

@Controller
@RequestMapping
public class TaskController {
    
    @Autowired
    private TaskService service;

    @GetMapping("/")
    public String list(Model model){
        List<Task> task = service.list();
        model.addAttribute("task", task);
        return "index";
    }

    @GetMapping("/newTask")
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Task task, Model model){
        service.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Optional<Task> task = service.listId(id);
        model.addAttribute("task", task);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/";
    }


}

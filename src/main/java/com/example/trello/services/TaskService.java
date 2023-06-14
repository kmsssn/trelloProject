package com.example.trello.services;


import com.example.trello.classes.Tasks;
import com.example.trello.impls.TaskImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskImplementation taskImplementation;

    public List<Tasks> getTaskByFolderId(Long id){
        return taskImplementation.getTaskByFolderId(id);
    }
    public Tasks getTaskById(Long id){
        return taskImplementation.getTaskById(id);
    }
    public void addTask(Tasks tasks){
        taskImplementation.addTask(tasks);
    }
    public void updTask(Tasks tasks){
        taskImplementation.updateTask(tasks);
    }
    public void deleteTask(Long id){
        taskImplementation.deleteById(id);
    }
}

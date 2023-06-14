package com.example.trello.reInterfaces;

import com.example.trello.classes.Tasks;

import java.util.List;

public interface TasksReInterface {

    Tasks addTask(Tasks tasks);
    List<Tasks> getAllTasks();
    List<Tasks> getTaskByFolderId(Long id);
    Tasks getTaskById(Long id);
    void deleteById(Long id);
}

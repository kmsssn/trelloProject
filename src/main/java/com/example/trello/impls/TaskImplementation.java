package com.example.trello.impls;

import com.example.trello.classes.Tasks;
import com.example.trello.reInterfaces.TasksReInterface;
import com.example.trello.repos.TaskRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskImplementation implements TasksReInterface {

    @Autowired
    private TaskRepos taskRepos;
    @Override
    public Tasks addTask(Tasks tasks) {
        return taskRepos.save(tasks);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepos.findAll();
    }

    @Override
    public List<Tasks> getTaskByFolderId(Long id) {
        return taskRepos.getAllByFoldersId(id);
    }
    public Tasks getTaskById(Long id){
        return taskRepos.findAllById(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepos.deleteById(id);
    }

    public Tasks updateTask(Tasks tasks){
        return taskRepos.save(tasks);
    }
    public void deleteAll(){
        taskRepos.deleteAll();
    }
}

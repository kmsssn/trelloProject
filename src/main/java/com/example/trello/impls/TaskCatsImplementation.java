package com.example.trello.impls;

import com.example.trello.classes.TaskCats;
import com.example.trello.reInterfaces.TaskCatsReInterface;
import com.example.trello.repos.TaskCatsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCatsImplementation implements TaskCatsReInterface {

    @Autowired
    private TaskCatsRepos taskCatsRepos;

    public List<TaskCats> getAllCats(){
        return taskCatsRepos.findAll();
    }
    @Override
    public TaskCats addTaskCat(TaskCats taskCats) {
        return taskCatsRepos.save(taskCats);
    }

    @Override
    public void updTaskCat(TaskCats taskCats) {
        taskCatsRepos.save(taskCats);
    }

    @Override
    public TaskCats getCatById(Long id) {
        return taskCatsRepos.findAllById(id);
    }

    @Override
    public void deleteCatById(Long id) {
        taskCatsRepos.deleteById(id);
    }

}

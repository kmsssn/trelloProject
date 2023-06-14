package com.example.trello.reInterfaces;

import com.example.trello.classes.TaskCats;

public interface TaskCatsReInterface {
    TaskCats addTaskCat(TaskCats taskCats);

    void updTaskCat(TaskCats taskCats);
    TaskCats getCatById(Long id);
    void deleteCatById(Long id);
}

package com.example.trello.services;

import com.example.trello.classes.Folders;
import com.example.trello.classes.TaskCats;
import com.example.trello.impls.FolderImplementation;
import com.example.trello.impls.TaskCatsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FolderService {
    @Autowired
    private FolderImplementation folderImplementation;


    @Autowired
    private TaskCatsImplementation taskCatsImplementation;


    public List<Folders> getAllFolder(){
        return folderImplementation.findAll();
    }
    public Folders getFolderById(Long id){
        return folderImplementation.getFolder(id);
    }
    public void addFolder(Folders folders){
         folderImplementation.addFolder(folders);
    }
    public void deleteFolder(Long folderId) {
        Folders folder = folderImplementation.getFolder(folderId);
        List<TaskCats> taskCats = taskCatsImplementation.getAllCats();
        List<TaskCats> categoriesToRemove = new ArrayList<>();

        for (TaskCats cat : folder.getCategories()) {
            for (TaskCats taskCat : taskCats) {
                if (Objects.equals(cat.getId(), taskCat.getId())) {
                    categoriesToRemove.add(cat);
                    break;
                }
            }
        }
        folder.getCategories().removeAll(categoriesToRemove);
        folderImplementation.updFolder(folder);
        folderImplementation.deleteFolderById(folderId);
    }
}

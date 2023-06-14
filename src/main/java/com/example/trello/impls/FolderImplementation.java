package com.example.trello.impls;

import com.example.trello.classes.Folders;
import com.example.trello.reInterfaces.FolderReInterface;
import com.example.trello.repos.FolderRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FolderImplementation implements FolderReInterface {

    @Autowired
    private FolderRepos repository;
    @Autowired
    private TaskCatsImplementation taskCatsImplementation;
    @Autowired
    private TaskImplementation taskImplementation;
    @Override
    public List<Folders> findAll() {
        return repository.findAll();
    }

    @Override
    public Folders getFolder(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addFolder(Folders folders) {
        repository.save(folders);
    }
    @Override
    public void deleteFolderById(Long id) {
        repository.deleteById(id);
    }
    public void updFolder(Folders folders){
        repository.save(folders);
    }
}

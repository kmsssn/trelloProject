package com.example.trello.reInterfaces;

import com.example.trello.classes.Folders;

import java.util.List;

public interface FolderReInterface {
    List<Folders> findAll();
    Folders getFolder(Long id);
    void addFolder(Folders folders);

    void deleteFolderById(Long id);
}

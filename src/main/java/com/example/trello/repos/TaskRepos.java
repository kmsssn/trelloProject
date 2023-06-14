package com.example.trello.repos;

import com.example.trello.classes.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepos extends JpaRepository<Tasks,Long> {
    List<Tasks> getAllByFoldersId(Long id);

    Tasks findAllById(Long id);
}

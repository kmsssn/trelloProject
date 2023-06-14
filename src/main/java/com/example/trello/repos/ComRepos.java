package com.example.trello.repos;

import com.example.trello.classes.Coms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComRepos extends JpaRepository<Coms,Long> {
    Coms findAllById(Long id);
}

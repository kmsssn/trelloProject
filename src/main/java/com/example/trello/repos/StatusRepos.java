package com.example.trello.repos;

import com.example.trello.classes.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepos extends JpaRepository<Status,Long> {
}

package com.example.trello.reInterfaces;

import com.example.trello.classes.Coms;

public interface ComReInterface {
    Coms addCom(Coms coms);
    Coms getCom(Long id);
    Coms getComsById(Long id);
    void deleteCom(Long id);
}

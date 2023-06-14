package com.example.trello.impls;

import com.example.trello.classes.Coms;
import com.example.trello.reInterfaces.ComReInterface;
import com.example.trello.repos.ComRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComImplementation implements ComReInterface {

    @Autowired
    private ComRepos comRepos;
    @Override
    public Coms addCom(Coms coms) {
        return comRepos.save(coms);
    }

    @Override
    public Coms getCom(Long id) {
        return comRepos.getReferenceById(id);
    }

    @Override
    public Coms getComsById(Long id) {
        return comRepos.findAllById(id);
    }

    @Override
    public void deleteCom(Long id) {
        comRepos.deleteById(id);
    }
}

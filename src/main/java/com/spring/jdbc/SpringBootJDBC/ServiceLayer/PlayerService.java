package com.spring.jdbc.SpringBootJDBC.ServiceLayer;

import com.spring.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerSpringDataRepository repo;

    //getAllplayers
    public List<Player>getAllPlayers(){
        return repo.findAll();
    }

    //findbyid
    public Player findPlayerByID(@PathVariable("id") int id){

        Optional<Player>tempPlayer=repo.findById(id);

        Player p= null;

        if(tempPlayer.isPresent()) p=tempPlayer.get();
        else {
            throw new RuntimeException("Player with ID "+id+ " not found");
        }
        return p;
    }
}


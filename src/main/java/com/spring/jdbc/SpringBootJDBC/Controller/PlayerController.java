package com.spring.jdbc.SpringBootJDBC.Controller;
import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import com.spring.jdbc.SpringBootJDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PlayerController {

//    @Autowired
//    PlayerDAO playerDAO;

    @Autowired
    PlayerService service;



//    @GetMapping("/playersById")
//    public Player getPlayerById(){
//        return playerDAO.getPlayerById(2);
//    }

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping("/welcome")
    public String welcome(){return "Welcome to Player";}

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.findPlayerByID(id);
    }

}
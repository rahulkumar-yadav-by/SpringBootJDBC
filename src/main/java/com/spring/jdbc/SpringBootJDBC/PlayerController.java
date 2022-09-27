package com.spring.jdbc.SpringBootJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
public class PlayerController {

    @Autowired
    PlayerDAO playerDAO;
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerDAO.getAllPlayers();
    }

    @GetMapping("/playersById")
    public Player getPlayerById(){
        return playerDAO.getPlayerById(2);
    }

}
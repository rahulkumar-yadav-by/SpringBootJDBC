package com.spring.jdbc.SpringBootJDBC.Controller;
import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import com.spring.jdbc.SpringBootJDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/addPlayer")
   // @RequestMapping(method=RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p){
        p.setID(2);
        return service.addPlayer(p);
    }

    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayer(@PathVariable int id,@RequestBody Player p){
        return service.updatePlayerById(id,p);
    }


    @PatchMapping("/patchPlayer/{id}")
    public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
        return service.patchPlayerById(id, playerPatch);
    }

    //updating with query(only for nationality)
    @PatchMapping("/patchPlayer/{id}/nationality")
    public void patchNationality(@PathVariable int id, @RequestBody String nationality){
        service.updateNationality(id,nationality);
    }

    //delete player
    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayer(id);
    }
}
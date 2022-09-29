package com.spring.jdbc.SpringBootJDBC.Repository;

import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//jpa : java persistence api(jpa based repository)
@Repository
@Transactional  // to make transactions b/w java classes and databases
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    //Get/Read
    public Player getPlayerById(int id){
        return entityManager.find(Player.class, id);
    }

    //Delete
    public void deletePlayerById(int id){
        Player player = entityManager.find(Player.class,id);
        entityManager.remove(player);
    }

    //getALLPlayers
    public List<Player>getAllPlayers(){
        TypedQuery<Player>getAll=entityManager.createNamedQuery("get_all_players",Player.class);
        return getAll.getResultList();
    }

    //

}

package com.spring.jdbc.SpringBootJDBC;

import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.Date;
import java.sql.Date;
@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

//	@Autowired
//	PlayerDAO dao;


	@Autowired
	PlayerRepository repo;



	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(dao.getAllPlayers());
//		System.out.println("____________________getAllPlayers()____________________\n\n");
//
//		System.out.println(dao.getPlayerById(2));
//		System.out.println("___________________getPlayerById()_____________________\n\n");
//
//		System.out.println(dao.insertPlayers(new Player(4,"Rohit",24,"Bangladesh",new Date(System.currentTimeMillis()),4)));
//		System.out.println("___________________insertPlayers()_____________________");
//		System.out.println(dao.getAllPlayers());
//		System.out.println("____________________getAllPlayers()____________________\n\n");
//
//		System.out.println(dao.updatePlayerInfo(new Player(4 , "Rohit", 27 , "NEW_PLACE", new Date(System.currentTimeMillis()), 20 )));
//		System.out.println("___________________updatePlayerInfo()_____________________");
//		System.out.println(dao.getAllPlayers());
//		System.out.println("____________________getAllPlayers()____________________\n\n");
//
//
//		System.out.println(dao.deletePlayer((4)));
//		System.out.println("___________________DeletePlayer()_____________________");
//		System.out.println(dao.getAllPlayers());
//		System.out.println("____________________getAllPlayers()____________________\n\n");



		//*********** CRUD WITHOUT DATABASE QUERIES *****************

		//CREATE
		repo.insertPlayer(new Player("Alice",22,"Indian",Date.valueOf("2000-02-02"),11));
		repo.insertPlayer(new Player("Bob",20,"Australian",Date.valueOf("2002-02-02"),121));

		//READ
		System.out.println(repo.getPlayerById(2));

		//UPDATE
		repo.updatePlayer(new Player(2,"Bob",20,"UPDATED_PLACE",Date.valueOf("2002-02-02"),121));


		//DELETE
		repo.deletePlayerById(2);

		//get
//		repo.getAllPlayers();
		System.out.println("hello  : "+ repo.getAllPlayers());
	}
}

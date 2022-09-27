package com.spring.jdbc.SpringBootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getAllPlayers());
		System.out.println("____________________getAllPlayers()____________________\n\n");

		System.out.println(dao.getPlayerById(2));
		System.out.println("___________________getPlayerById()_____________________\n\n");

		System.out.println(dao.insertPlayers(new Player(4,"Rohit",24,"Bangladesh",new Date(System.currentTimeMillis()),4)));
		System.out.println("___________________insertPlayers()_____________________");
		System.out.println(dao.getAllPlayers());
		System.out.println("____________________getAllPlayers()____________________\n\n");

		System.out.println(dao.updatePlayerInfo(new Player(4 , "Rohit", 27 , "NEW_PLACE", new Date(System.currentTimeMillis()), 20 )));
		System.out.println("___________________updatePlayerInfo()_____________________");
		System.out.println(dao.getAllPlayers());
		System.out.println("____________________getAllPlayers()____________________\n\n");


		System.out.println(dao.deletePlayer((4)));
		System.out.println("___________________DeletePlayer()_____________________");
		System.out.println(dao.getAllPlayers());
		System.out.println("____________________getAllPlayers()____________________\n\n");


	}
}

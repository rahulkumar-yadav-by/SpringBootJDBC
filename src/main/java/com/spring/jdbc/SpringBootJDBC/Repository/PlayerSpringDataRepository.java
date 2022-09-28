package com.spring.jdbc.SpringBootJDBC.Repository;

import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
    public List<Player>findByNationality(String Nationality);


}

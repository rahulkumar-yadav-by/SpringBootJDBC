package com.spring.jdbc.SpringBootJDBC.Repository;

import com.spring.jdbc.SpringBootJDBC.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers(){

        //Reading the Table
        String getPlayerQuery= "SELECT * FROM Player";
        //JDBC TEMPLATE => Query =>Database =>result set=> row mapped => player.class =>list<Object>

        //using Bean Mapper(InBuilt)
//        return jdbcTemplate.query(getPlayerQuery, new BeanPropertyRowMapper<Player>(Player.class));

        //using PlayerMapper(Custom)
        return jdbcTemplate.query(getPlayerQuery, new PlayerMapper());
    }


    //Read (BY ID)
    public Player getPlayerById(int id){
        String getPlayerByIdQuery="SELECT * FROM Player WHERE ID = ?";
        //JDBC TEMPLATE => Query => ID is being substituted as a primary key=> database => result set =>
        return jdbcTemplate.queryForObject(getPlayerByIdQuery, new BeanPropertyRowMapper<Player>(Player.class),new Object[]{id});
    }



    //Inserting a new Row
    public int insertPlayers(Player player){
        String insertPlayerQuery="INSERT INTO Player VALUES(?,?,?,?,?,?)";
//        return jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getID(),player.getName(),player.getAge(),
//                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation() });
        return jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getID(),player.getName(),player.getAge(),
                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation() });
    }

    //UPDATE
    public int updatePlayerInfo(Player player){
        String updatePlayerQuery="Update Player " + "SET Name=? , Age =?, Nationality=?, DOB=?, Designation=?" +
                "WHERE ID=?";
//        return jdbcTemplate.update(updatePlayerQuery,new Object[]{player.getName(),player.getAge(),
//                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation(),player.getID() });
        return jdbcTemplate.update(updatePlayerQuery,new Object[]{player.getName(),player.getAge(),
                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation(),player.getID() });
    }

    //DELETING
    public int deletePlayer(int id){
        String deleteQuery = "DELETE FROM Player " + "WHERE ID = ?";
//        return jdbcTemplate.update(deleteQuery, new Object[]{id});
        return jdbcTemplate.update(deleteQuery,new Object[]{id});
    }



    private static final class PlayerMapper implements RowMapper{
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player=new Player();

            player.setID(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));

            return player;

        }
    }


}

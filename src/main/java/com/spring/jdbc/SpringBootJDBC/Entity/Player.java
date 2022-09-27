package com.spring.jdbc.SpringBootJDBC.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity                //RowMapping (Create database/schema)
@NamedQuery(name="get_all_players",query = "SELECT p FROM Player p")
@Table(name="Player") //give the table name
public class Player {

    @Id
    @GeneratedValue

    private int ID;  //auto generated id value on new row insertion

    @Column(name="Name")
    private String name;
    @Column(name="Age")
    private int age;
    @Column(name="Nationality")
    private String nationality;
    @Column(name="DOB")
    private Date dob;
    @Column(name="Destination")
    private int designation;

    public Player(){}

    public Player(int pid, String name, int age, String nationality, Date dob, int designation) {
        this.ID = pid;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }
    public Player( String name, int age, String nationality, Date dob, int designation) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }



    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDob() {
        return dob;
    }

    public int getDesignation() {
        return designation;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                ", designation=" + designation +
                '}';
    }
}

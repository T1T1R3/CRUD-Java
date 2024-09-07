/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.crud.user;

import java.time.LocalDate;

/**
 *
 * @author ana
 */
public class User {

    private String name;
    private String email;
    private String password;
    private LocalDate lastAcess;
    private Boolean active;

    public User() {
    }

    public User(String name, String email, String password, LocalDate lastAcess, Boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastAcess = lastAcess;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastAcess() {
        return lastAcess;
    }

    public void setLastAcess(LocalDate lastAcess) {
        this.lastAcess = lastAcess;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}

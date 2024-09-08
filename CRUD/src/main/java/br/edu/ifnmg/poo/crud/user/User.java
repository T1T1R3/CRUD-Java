/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.crud.user;

import br.edu.ifnmg.poo.crud.entity.Entity;
import java.time.LocalDate;

/**
 *
 * @author ana
 */
public class User extends Entity {

    private String name;
    private String email;
    private String password;
    private LocalDate lastAcess;
    private Boolean active;

    public User() {
    }

    public User(String name, String email, String password, LocalDate lastAcess, Boolean active) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setLastAcess(lastAcess);
        setActive(active);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null name is not accepted.");
        } else if (name.length() > 150) {
            throw new IllegalArgumentException("The name exceeds 150 characters.");
        }
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

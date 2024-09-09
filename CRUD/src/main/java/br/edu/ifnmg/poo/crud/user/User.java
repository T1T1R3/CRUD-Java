package br.edu.ifnmg.poo.crud.user;

import br.edu.ifnmg.poo.crud.entity.Entity;
import java.time.LocalDateTime;

/**
 *
 * @author ana
 */
public class User extends Entity {

    private String name;
    private String email;
    private String password;
    private LocalDateTime lastAccess;
    private Boolean active;

    public User() {
    }

    public User(String name, String email, String password, LocalDateTime lastAccess, Boolean active) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setLastAccess(lastAccess);
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
        if (email == null) {
            throw new IllegalArgumentException("Null email is not accepted.");
        } else if (email.length() > 255) {
            throw new IllegalArgumentException("The email exceeds 255 characters.");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Null password is not accepted.");
        } else if (password.length() > 64) {
            throw new IllegalArgumentException("The password exceeds 64 characters.");
        }
        this.password = password;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        if (lastAccess == null) {
            return "User{"
                    + "name=" + name
                    + ", email=" + email
                    + ", password=" + password
                    + ", lastAccess=" + "Never Accessed"
                    + ", active=" + active
                    + '}';
        }
        return "User{"
                + "name=" + name
                + ", email=" + email
                + ", password=" + password
                + ", lastAccess=" + lastAccess
                + ", active=" + active
                + '}';
    }

}

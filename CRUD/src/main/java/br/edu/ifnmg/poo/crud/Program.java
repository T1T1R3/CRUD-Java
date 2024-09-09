/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.poo.crud;
import java.sql.*;

import br.edu.ifnmg.poo.crud.repository.DbConnection;
import br.edu.ifnmg.poo.crud.user.User;
import br.edu.ifnmg.poo.crud.user.UserDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author ana
 */
public class Program {

    public static void main(String[] args) {
        User user1 = new User("Ana Zaira", "a.zaira@mail.com", "123",
                LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(17, 0)), Boolean.TRUE);

        User user2 = new User("Beatriz Yana", "b.yana@mail.com", "456",
                LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0)), Boolean.TRUE);

        User user3 = new User("Cecília Xerxes", "c.xerxes@mail.com", "789",
                LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.of(12, 0)), Boolean.TRUE);

        User user4 = new User("Débora Wendel", "debora.w@mail.com", "147", null, Boolean.FALSE);
        // para corrigir,na classe User, o lastAccess pode ser null

        User user5 = new User("Eugênia Vale", "e.vale@mail.com", "258",
                LocalDateTime.of(LocalDate.now(), LocalTime.of(6, 0)), Boolean.TRUE);

        User user6 = new User("Fernanda Uchoa", "f.vale@mail.com", "369",
                LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(23, 59)), Boolean.FALSE);


        Long user1id = new UserDao().saveOrUpdate(user1);
        user1.setId(user1id);

        Long user2id = new UserDao().saveOrUpdate(user2);
        user2.setId(user2id);

        Long user3id = new UserDao().saveOrUpdate(user3);
        user3.setId(user3id);

        Long user4id = new UserDao().saveOrUpdate(user4);
        user4.setId(user4id);

        Long user5id = new UserDao().saveOrUpdate(user5);
        user5.setId(user5id);

        Long user6id = new UserDao().saveOrUpdate(user6);
        user6.setId(user6id);


        user1.setLastAccess(LocalDateTime.now());
        new UserDao().saveOrUpdate(user1);

        user3.setActive(Boolean.FALSE);
        new UserDao().saveOrUpdate(user3);

        user4.setEmail("d.wendel@mail.com");
        user4.setPassword("&Yh4$Wu9");
        new UserDao().saveOrUpdate(user4);

        user5.setPassword("asdfqwerty");
        user5.setLastAccess(LocalDateTime.now());
        new UserDao().saveOrUpdate(user5);


        User printUser3 = new UserDao().findById(3L);
        System.out.println(printUser3);

        System.out.println();

        List<User> allUser = new UserDao().findAll();

        for(User user: allUser)
            System.out.println(user);

        System.out.println();

        for(User user: allUser){
            if(user.getActive() == Boolean.TRUE)
                System.out.println(user);
        }

        new UserDao().delete(4L);

    }
}

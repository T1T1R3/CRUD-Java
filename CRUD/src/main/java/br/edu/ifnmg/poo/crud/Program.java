/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.poo.crud;

import br.edu.ifnmg.poo.crud.user.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author ana
 */
public class Program {

    public static void main(String[] args) {
        User user1 = new User("Ana Zaira", "a.zaira@mail.com", "123", 
                LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(17, 0)), Boolean.TRUE);
        
        System.out.println(user1);
    }
}

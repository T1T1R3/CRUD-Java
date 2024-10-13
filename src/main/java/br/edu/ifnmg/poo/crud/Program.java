package br.edu.ifnmg.poo.crud;

import br.edu.ifnmg.poo.crud.user.User;
import br.edu.ifnmg.poo.crud.user.UserDao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AnaLuizanc
 * @author T1T1R3
 */
public class Program {

    public static void main(String[] args) {

        //<editor-fold defaultstate="collapsed" desc="Adiciona usuários">
        User user1 = new User("Ana Zaira", "a.zaira@mail.com", "123",
                LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(17, 0)), Boolean.TRUE);

        User user2 = new User("Beatriz Yana", "b.yana@mail.com", "456",
                LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 0)), Boolean.TRUE);

        User user3 = new User("Cecília Xerxes", "c.xerxes@mail.com", "789",
                LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.of(12, 0)), Boolean.TRUE);

        User user4 = new User("Débora Wendel", "debora.w@mail.com", "147", null, Boolean.FALSE);

        User user5 = new User("Eugênia Vale", "e.vale@mail.com", "258",
                LocalDateTime.of(LocalDate.now(), LocalTime.of(6, 0)), Boolean.TRUE);

        User user6 = new User("Fernanda Uchoa", "f.vale@mail.com", "369",
                LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(23, 59)), Boolean.FALSE);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Adiciona usuários no banco de dados ">
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
        //</editor-fold>

        // Atualiza 'lastAccess' do user1
        user1.setLastAccess(LocalDateTime.now());
        new UserDao().saveOrUpdate(user1);

        // Atualiza 'active' do user3
        user3.setActive(Boolean.FALSE);
        new UserDao().saveOrUpdate(user3);

        // Atualiza 'email' e 'password' do user4
        user4.setEmail("d.wendel@mail.com");
        user4.setPassword("&Yh4$Wu9");
        new UserDao().saveOrUpdate(user4);

        // Atualiza 'password' e 'lastAccess' do user5
        user5.setPassword("asdfqwerty");
        user5.setLastAccess(LocalDateTime.now());
        new UserDao().saveOrUpdate(user5);

        // Imprime o 3° objeto do banco de dados
        User printUser3 = new UserDao().findById(3L);
        System.out.println(printUser3);

        // Quebra de linha
        System.out.println();

        // Imprime todos os objetos do banco de dados
        List<User> allUser = new UserDao().findAll();

        for (User user : allUser) {
            System.out.println(user);
        }

        // Quebra de linha
        System.out.println();

        // Imprime todos os objetos do banco de dados que possuem 'active' TRUE
        for (User user : allUser) {
            if (Objects.equals(user.getActive(), Boolean.TRUE)) {
                System.out.println(user);
            }
        }

        // Deleta o 4° objeto do banco de dados
        new UserDao().delete(4L);

    }
}

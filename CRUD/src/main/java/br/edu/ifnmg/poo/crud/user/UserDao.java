
package br.edu.ifnmg.poo.crud.user;

import br.edu.ifnmg.poo.crud.repository.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ana
 */
public class UserDao extends Dao<User>{
    public static final String TABLE = "user";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(name, email, password, lastAccess, active) values (?, ?, ?, ?, ?)";
    }

    
    
    
}

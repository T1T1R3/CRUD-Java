
package br.edu.ifnmg.poo.crud.user;

import br.edu.ifnmg.poo.crud.repository.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set email = ?, password = ?, lastAccess = ?, active = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select * from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select * from " + TABLE;
    }

    @Override
    public String getDeleteStatement() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User e) {
        try {
            if (e.getId() != null){
                pstmt.setString(1, e.getEmail());
                pstmt.setString(2, e.getPassword());
                pstmt.setObject(3, e.getLastAccess(), Types.DATE);
                pstmt.setBoolean(4, e.getActive());
                pstmt.setLong(5, e.getId());
            }
            else{
                pstmt.setString(1, e.getName());
                pstmt.setString(2, e.getEmail());
                pstmt.setString(3, e.getPassword());
                pstmt.setObject(4, e.getLastAccess(), Types.DATE);
                pstmt.setBoolean(5, e.getActive());
            }
        }
        catch (Exception ex){
            System.out.println("Error: " +  ex);
        }
    }

    @Override
    public User extractObject(ResultSet rs) {
        User user = null;

        try {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setLastAccess(rs.getObject("lastAccess", LocalDateTime.class));
            user.setActive(rs.getBoolean("active"));

        } catch (Exception exception) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, exception);
        }
        return user;
    }

    
    
}

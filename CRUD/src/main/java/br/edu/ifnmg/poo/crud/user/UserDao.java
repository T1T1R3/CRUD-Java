
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

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " email = ?, password = ?, lastAccess = ?, active = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User extractObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}

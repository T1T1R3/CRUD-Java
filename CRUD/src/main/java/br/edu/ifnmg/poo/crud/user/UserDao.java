
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
        return "select id from " + TABLE + " where id = ?";
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
        try{
            pstmt.setString(1, e.getName());
            pstmt.setString(2, e.getEmail());
            pstmt.setString(3, e.getPassword());
            pstmt.setObject(4, e.getLastAccess());
            pstmt.setBoolean(5, e.getActive());

            System.out.println(pstmt);
        }
        catch (Exception ex){
            System.out.println("Error: " +  ex);
        }
    }

    @Override
    public User extractObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.poo.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.Class;


/**
 *
 * @author ana
 */
public class CRUD {
    public static void connection(){
        Statement st;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "");
            st = con.createStatement();
            System.out.println("Connected");
            /*ResultSet result = st.executeQuery("select * from t1");{
                String value = result.getNString("nome");
                System.out.println(value);
            }*/
            con.close();
        }catch (Exception e){
            System.out.println("Not connected: " + e);
        }


    }
    public static void main(String[] args) {
        connection();
    }
}

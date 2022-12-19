package com.mycompany.gh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAdd {
    
    private String url = "jdbc:postgresql://localhost:4572/hg";
    private String user = "postgres";
    private String password = "admin";
    
    /**
     *
     * @param name
     * @param lastname
     * @param email
     * @param pswd
     * @param role
     */
    public void add(String name, String lastname, String email, String pswd, String role) {
        

        String query = "INSERT INTO \"user\"(name, lastname, email, password, role) VALUES(?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, lastname);
            pst.setString(3, email);
            pst.setString(4, pswd);
            pst.setString(5, role);
            pst.executeUpdate();
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserAdd.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    
    public String find(String email, String pswd) {

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"user\"");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
            
                if ((rs.getString(1).equals(email))&&(rs.getString(2).equals(pswd))) {
                    return rs.getString(5);
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserAdd.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "0";
    }
    
    public void show() {

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"user\"");
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
            
                System.out.print(rs.getString(1));
                System.out.print(": ");
                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.print(rs.getString(3));
                System.out.print(": ");
                System.out.print(rs.getString(4));
                System.out.print(": ");
                System.out.println(rs.getString(5));
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserAdd.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
}

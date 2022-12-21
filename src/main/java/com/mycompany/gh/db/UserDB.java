package com.mycompany.gh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {
    
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
    public boolean add(String name, String lastname, String email, String pswd, String role) {
        

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

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return true;
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

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return "0";
    }
    
    public String[] show(String login) throws SQLException {
        String[] param = new String[5];
        String query = "SELECT * FROM \"user\" WHERE email=?";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)){
                pst.setString(1, login);
                ResultSet rs = pst.executeQuery();
                param[0] = rs.getString(1);
                param[1] = rs.getString(2);
                param[2] = rs.getString(3);
                param[3] = rs.getString(4);
                param[4] = rs.getString(5);
            
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return param;
    }
    
}

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
    
    
    public void delete(String login) {
        System.out.println("deleteData started...");
        String query = "DELETE FROM \"user\" WHERE email=?";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, login);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("deleteData ended...");
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
    
    public void setRole(String login, String role) {
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("UPDATE \"user\" SET role = ? WHERE email = ?")) {
            pst.setString(1, role);
            pst.setString(2, login);
            pst.executeUpdate();
            
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public String[] getUser(String login) throws SQLException {
        String[] param = new String[5];
        String query = "SELECT * FROM \"user\" WHERE email = ?";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)){
                pst.setString(1, login);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    param[0] = rs.getString(1);
                    param[1] = rs.getString(2);
                    param[2] = rs.getString(3);
                    param[3] = rs.getString(4);
                    param[4] = rs.getString(5);
                }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return param;
    }
    
    public int count() throws SQLException {
        System.out.println("count connected...");
        int count = -1;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                
            PreparedStatement stmt = con.prepareStatement("select count(*) from \"user\"");
            ResultSet res = stmt.executeQuery()) {
                res.next();
                count = res.getInt(1);
            }  
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("cout ended...");
        return count;
    }
    
    public String[][] getData(String login) throws SQLException {
        System.out.println("getData started...");
        int n = this.count();
        String[][] param = new String[n-1][4];
            
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"user\" WHERE email != ?")) {
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                param[i][0] = rs.getString(3);
                param[i][1] = rs.getString(4);
                param[i][2] = rs.getString(1);
                param[i][3] = rs.getString( 5);       
                i+=1;         
            }
            System.out.println("connected to parts DB...");
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("getData ended...");
        return param;
    }
    
}

package com.mycompany.gh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDB {
    
    private String url = "jdbc:postgresql://localhost:4572/hg";
    private String user = "postgres";
    private String password = "admin";
    
    public int count() throws SQLException {
        System.out.println("count connected...");
        int count = -1;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                
            PreparedStatement stmt = con.prepareStatement("select count(*) from work_type");
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
    
    public String[] getWorkType() throws SQLException {
        System.out.println("getData started...");
        int n = this.count();
        String[] param = new String[n];
        System.out.println("Проблема в запросе");    
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM work_type");    
            ResultSet rs = pst.executeQuery()) {
            int i = 0;
            while (rs.next()) {
                param[i] = rs.getString(2); 
                System.out.println("iteration " + i);
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
    
    public int countWork() throws SQLException {
        System.out.println("count connected...");
        int count = -1;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                
            PreparedStatement stmt = con.prepareStatement("select count(*) from \"work\"");
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
    
    public String[] getWork(String type) throws SQLException {
        System.out.println("getData started...");
        int n = this.countWork();
        String[] param = new String[n];
        System.out.println("Проблема в запросе");    
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT work_name FROM \"work\" INNER JOIN work_type ON"
                    + "\"work\".work_type_id=work_type.work_type_id WHERE work_type_name=?")    
            ) {
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                param[i] = rs.getString(1); 
                System.out.println("iteration " + i);
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
    
    public String[] getWorkTable(String type, String work) throws SQLException {
        System.out.println("getData started...");
        String[] param = new String[4];
        System.out.println("Проблема в запросе");    
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT work_type_name, work_name, execution_duration, work_cost FROM \"work\" INNER JOIN work_type ON"
                    + "\"work\".work_type_id=work_type.work_type_id WHERE work_type_name=? and work_name=?")) {
            pst.setString(1, type);
            pst.setString(2, work);
            ResultSet rs = pst.executeQuery();
            rs.next();
            param[0] = rs.getString(1);
            param[1] = rs.getString(2);
            param[2] = rs.getString(3);
            param[3] = Integer.toString(rs.getInt(4));
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("getData ended...");
        return param;
    }
    
    public int setOrder(String name, String lastname, String phone, String email, String status) {
        String query = "INSERT INTO \"order\"(name, lastname, phone, email, status) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, lastname);
            pst.setString(3, phone);
            pst.setString(4, email);
            pst.setString(5, status);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        int work_id = 0;
        query = "SELECT MAX(order_id)\n" +
                "FROM \"order\"\n" +
                "WHERE name=? AND lastname=? AND phone=? AND email=? AND status=?";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, lastname);
            pst.setString(3, phone);
            pst.setString(4, email);
            pst.setString(5, status);
            ResultSet rs = pst.executeQuery();
            rs.next();
            work_id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return work_id;
    }
    
    public void setOrderWork(String work, int orderId) throws SQLException {
        int workId = 0; 
        String query = "SELECT work_id \n" +
                        "FROM work \n" +
                        "WHERE work_name=? ";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, work);
            ResultSet rs = pst.executeQuery();
            rs.next();
            workId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        query = "INSERT INTO order_work (order_id, work_id, status)\n" +
                "VALUES (?, ?, 'Невыполнена')";
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, orderId);
            pst.setInt(2, workId);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}

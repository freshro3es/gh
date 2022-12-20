package com.mycompany.gh.db;

import com.mycompany.gh.db.UserDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartDB {
    private String url = "jdbc:postgresql://localhost:4572/hg";
    private String user = "postgres";
    private String password = "admin";

    
    public int count() throws SQLException {
        System.out.println("count connected...");
        int count = -1;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                
            PreparedStatement stmt = con.prepareStatement("select count(*) from part");
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
    
    public void setData(String[] param) {
        System.out.println("setData started...");
        
        String query = "INSERT INTO part (id, name, type, price, amount, order_id) VALUES  (DEFAULT, ?, ?, ?, ?, ?);";
        
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            System.out.println("connected to parts DB...");
            pst.setString(1, param[0]);
            pst.setString(2, param[1]);
            pst.setInt(3, Integer.parseInt(param[2]));
            pst.setInt(4, Integer.parseInt(param[3]));
            pst.setInt(5, Integer.parseInt(param[4]));       
            pst.executeUpdate();
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("setData ended...");
    }
    
    public String[][] getData() throws SQLException {
        System.out.println("getData started...");
        int n = this.count();
        String[][] param = new String[n][5];
            
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM part");    
            ResultSet rs = pst.executeQuery()) {
            int i = 0;
            while (rs.next()) {
                param[i][0] = rs.getString(2);
                param[i][1] = rs.getString(3);
                param[i][2] = Integer.toString(rs.getInt(4));
                param[i][3] = Integer.toString(rs.getInt(5));
                param[i][4] = Integer.toString( rs.getInt(6));       
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

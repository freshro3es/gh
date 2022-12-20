package com.mycompany.gh;

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
        return count;
    }
    
    
    public String[][] getData() throws SQLException {
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
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return param;
    }
}

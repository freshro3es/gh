package com.mycompany.gh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    
    private String url = "jdbc:postgresql://localhost:4572/hg";
    private String user = "postgres";
    private String password = "admin";
    
    public int count(String query) throws SQLException {
        int count = 0;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);             
            PreparedStatement stmt = con.prepareStatement(query);
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
    
    public int count(String[] param, String query) throws SQLException {
        int count = 0;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);  
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setString(i+1, param[i]);
            }
            ResultSet res = pst.executeQuery();
                res.next();
                count = res.getInt(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return count;
    }
    
    public int count(int[] param, String query) throws SQLException {
        int count = 0;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);  
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setInt(i+1, param[i]);
            }
            ResultSet res = pst.executeQuery();
                res.next();
                count = res.getInt(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return count;
    }
    
    public String[] getColumn(int size, String query) throws SQLException {
        String[] array = new String[size];
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query);    
            ResultSet rs = pst.executeQuery()) {
            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString(1); 
                i+=1;
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return array;
    }
    
    public String[] getColumn(int size, String[] param, String query) throws SQLException {
        String[] array = new String[size];
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)    
            ) {
            for (int i=0; i<param.length; i++) {
                pst.setString(i+1, param[i]);
            }
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString(1); 
                i+=1;
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return array;
    }
    
    public String[] getRow(int size, String[] param, String query) throws SQLException {
        String[] array = new String[size];
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setString(i+1, param[i]);
            }
            ResultSet rs = pst.executeQuery(); 
            rs.next();
            for (int i=0; i<size; i++) {
                array[i] = rs.getString(i+1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return array;
    }
    
    public void setRow(String[] param, String query) {
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setString(i+1, param[i]);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public int getItem(String[] param, String query) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setString(i+1, param[i]);
            }
            ResultSet rs = pst.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }
    
    public void setRow(int[] param, String query) {
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            for (int i=0; i<param.length; i++) {
                pst.setInt(i+1, param[i]);
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public String[][] getList(int sizex, int sizey, int[] param, String query) throws SQLException {
        String[][] array = new String[sizex][sizey];   
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, param[0]);
            ResultSet rs = pst.executeQuery();
            for (int i=0; i<sizex; i++) {
                rs.next();
                for (int j=0; j<sizey; j++) {
                    array[i][j] = rs.getString(j+1);
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return array;
    }
    
    public String[][] getList(int sizex, int sizey, String[] param, String query) throws SQLException {
        String[][] array = new String[sizex][2];   
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
            PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, param[0]);
            ResultSet rs = pst.executeQuery();
            for (int i=0; i<sizex; i++) {
                rs.next();
                for (int j=0; j<sizey; j++) {
                    array[i][j] = rs.getString(j+1);
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UserDB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return array;
    }
}


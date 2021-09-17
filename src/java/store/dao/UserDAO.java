/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import store.connection.DBConnection;

/**
 *
 * @author DELL
 */
public class UserDAO implements Serializable{
    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }

    }
    
    public String checkLogin(String username, String password) throws Exception
    {
        String role = "";
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Select RoleID From tblUser Where Username = ? and Password = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setString(2, password);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("RoleID");
                }
            }
        }finally{
            closeConnection();
        }
        return role;
    }
    
    public String checkRole(String roleID) throws Exception
    {
        String role = "";
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Select Rolename From tblRole Where RoleID = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, roleID);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("Rolename");
                }
            }
        }finally{
            closeConnection();
        }
        return role;
    }
}

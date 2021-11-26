/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungnb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trungnb.utils.DBConnect;

/**
 *
 * @author PC
 */
public class UserDAO {
    public boolean checkUserLogin(String userID, String password) 
                    throws SQLException, ClassNotFoundException{
        int checkLogin = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            con = DBConnect.makeConnection();

            String sql = " SELECT userID FROM Users "
                    + " WHERE userID = ? and password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
 
                rs = stm.executeQuery();
            if(rs.next()) 
                return true;
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }finally {
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        
        return false;
    }
}

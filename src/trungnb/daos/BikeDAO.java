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
import java.util.ArrayList;
import trungnb.dtos.BikeDTO;
import trungnb.utils.DBConnect;

/**
 *
 * @author PC
 */
public class BikeDAO {
    public ArrayList loadBike() {
        ArrayList<BikeDTO> listBike = new ArrayList<>();
        String sql = "SELECT motocycleID, model, year, condition, price, quantity, warranty, brandID"
                + " FROM tblBike ";
        try (Connection con = DBConnect.makeConnection();
                PreparedStatement stm =con.prepareStatement(sql);){
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                String motocycleID = rs.getString("motocycleID");
                String model = rs.getString("model");
                String year = rs.getString("year"); 
                String condition = rs.getString("condition");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");
                BikeDTO bikeDTO = new BikeDTO(motocycleID, model, year, condition, price, quantity, warranty, brandID);
                listBike.add(bikeDTO);
            }
        } catch (Exception e) {
        }
        return listBike;
    }
    
    public int insertNewBike(BikeDTO bkDTO) throws SQLException, ClassNotFoundException{
        String sql = "INSERT tblBike Values(?,?,?,?,?,?,?,?)";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql);) {
                stm.setString(1, bkDTO.getMotocycleID());
                stm.setString(2, bkDTO.getModel());
                stm.setString(3, bkDTO.getYear());
                stm.setString(4, bkDTO.getCondition());
                stm.setString(5, bkDTO.getPrice());
                stm.setString(6, bkDTO.getQuantity());
                stm.setString(7, bkDTO.getWarranty());
                stm.setString(8, bkDTO.getBrandID());
                return stm.executeUpdate();
        }
        
    }
    
    public int updateBike(BikeDTO bkDTO) throws SQLException, ClassNotFoundException{ 
        String sql = "UPDATE tblBike SET model = ?, year = ?,condition = ?,price = ? , quantity = ?, warranty = ?, brandID = ?"
                + "  WHERE motocycleID = ?";
        try (Connection con = DBConnect.makeConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, bkDTO.getModel());
            stm.setString(2, bkDTO.getYear());
            stm.setString(3, bkDTO.getCondition());
            stm.setString(4, bkDTO.getPrice());
            stm.setString(5, bkDTO.getQuantity());
            stm.setString(6, bkDTO.getWarranty());
            stm.setString(7, bkDTO.getBrandID());
            stm.setString(8, bkDTO.getMotocycleID());
            return stm.executeUpdate();
        }
    }
    
    public int deteleBike(String bikeID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM tblBike WHERE motocycleID = ?";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, bikeID);
            return stm.executeUpdate();
        }
    }
    
    public boolean checkDuplicateBike(String motocycleID) throws SQLException, ClassNotFoundException{
        String sql = "SELECT motocycleID "
                + " FROM tblBike "
                + " WHERE motocycleID = ?";
        
        try (Connection con = DBConnect.makeConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, motocycleID);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return  true;
            }
        }
        return false;
    }
}

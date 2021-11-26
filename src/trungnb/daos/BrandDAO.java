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
import trungnb.dtos.BrandDTO;
import trungnb.utils.DBConnect;

/**
 *
 * @author PC
 */
public class BrandDAO {
    ArrayList<String> listBrandName = new ArrayList();
    
    public ArrayList loadBrand() throws SQLException, ClassNotFoundException {
        ArrayList<BrandDTO> listBrand = new ArrayList<>();

        String sql = "SELECT brandID,brandName,country,decription"
                        + " FROM tblBrand ";
        
        try (Connection con = DBConnect.makeConnection();
             PreparedStatement stm = con.prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                String brandID = rs.getString("brandID");
                String brandName = rs.getString("brandName");
                String country = rs.getString("country");
                String description = rs.getString("decription");
                BrandDTO brDTO = new BrandDTO(brandID, brandName, country, description);
                listBrand.add(brDTO);
            }
            return listBrand;
        }
        
    }
    
    public int insertNewBrand(BrandDTO brDTO) throws SQLException, ClassNotFoundException{
        String sql = "INSERT tblBrand VALUES(?,?,?,?)";
        try (Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)){
            
            stm.setString(1, brDTO.getBrandID());
            stm.setString(2, brDTO.getBrandName());
            stm.setString(3, brDTO.getBrandCountry());
            stm.setString(4, brDTO.getBrandDesciption());            
            return stm.executeUpdate();
        }    
    }
    
    
    public int updateBrand(BrandDTO brDTO) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE tblBrand SET brandName = ?, country = ?,decription = ? WHERE brandID = ?";
        try (Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)){
            
            stm.setString(1, brDTO.getBrandName());
            stm.setString(2, brDTO.getBrandCountry());
            stm.setString(3, brDTO.getBrandDesciption()); 
            stm.setString(4, brDTO.getBrandID());
            return stm.executeUpdate();
        }    
    }
    
    public int deteleBrand(String brandID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM tblBrand WHERE brandID = ?";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, brandID);
            return stm.executeUpdate();
        }
    }
    
    public ArrayList getBrandNameForCbbox() throws SQLException, ClassNotFoundException{
        String sql = "SELECT brandName, brandID "
                + " FROM tblBrand";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                String id = rs.getString("brandID");
                String name = rs.getString("brandName");
                listBrandName.add(id + " - " + name);
            } 
        }
        return listBrandName;       
    }
    
//    public String getBrandIDByName(String brandName) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT brandID "
//                + " FROM tblBrand "
//                + " WHERE brandName = ?";
//        try(Connection con = DBConnect.makeConnection();
//            PreparedStatement stm = con.prepareStatement(sql)) {
//            
//            stm.setString(1, brandName);
//            ResultSet rs = stm.executeQuery();
//            if(rs.next()) {            
//                return rs.getString("brandID");
//            }else
//                return "";
//        }       
//    }
    
    public String getBrandNameByID(String brandID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT brandName "
                + " FROM tblBrand  "
                + " WHERE brandID = ?";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {
            
            stm.setString(1, brandID);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {            
                return rs.getString("brandName");
            }else
                return "";
        }       
    }
    
    public int count(String brandID) throws SQLException, ClassNotFoundException {
        int count = 0;
        String sql = "SELECT count(motocycleID)  AS Count "
                + " FROM tblBike "
                + " WHERE brandID = ?";
        try(Connection con = DBConnect.makeConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, brandID);
            ResultSet rs = stm.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        return count;
    }
    
    public boolean checkDuplicate(String brandID) throws SQLException, ClassNotFoundException{
        String sql = "SELECT brandID "
                + " FROM tblBrand "
                + " WHERE brandID = ?";
        
        try (Connection con = DBConnect.makeConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, brandID);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                return  true;
            }
        }
        return false;
    }
}

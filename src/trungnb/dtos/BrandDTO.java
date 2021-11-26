/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungnb.dtos;

/**
 *
 * @author PC
 */
public class BrandDTO {
    private String brandID;
    private String brandName;
    private String brandCountry;
    private String brandDeciption;

    public BrandDTO() {
    }

    public BrandDTO(String brandID, String brandName, String brandCountry, String brandDesciption) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
        this.brandDeciption = brandDesciption;
    }

    
    
    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public String getBrandDesciption() {
        return brandDeciption;
    }

    public void setBrandDesciption(String brandDesciption) {
        this.brandDeciption = brandDesciption;
    }
}

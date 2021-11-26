/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungnb.utils;

/**
 *
 * @author PC
 */
public class checkInput {
    public static String checkID(String id){
        if(id.isEmpty()) return "ID can not null\n";
        if(id.contains("   ")) return "ID can not have more than 3 blank\n";
        if(id.length()>10) return "ID max length is 10 charaters.";
        String formatID = "^[a-zA-Z0-9\\s]+";
        if(!id.matches(formatID)) return "ID  can not have special characters\n";
        return "";
    }
    
    public static String checkName(String name){
        if(name.isEmpty()) return "Name can not null\n";
        if(name.contains("   ")) return "Name can not have more than 3 blank\n";
        if(name.length()>50) return "Name max length is 50 characters\n";
        String formatName = "^[a-zA-Z\\s]+";
        if(!name.matches(formatName)) return "Name can not have numbers\n";
        return "";
    }
    
    public static String checkCountry(String country){
        if(country.isEmpty()) return "Country can not null\n";
        if(country.contains("   ")) return "Country can not have more than 3 blank\n";
        if(country.length()>50) return "Country max length is 50 characters\n";
        String formatCountry = "^[a-zA-Z\\s]+";
        if(!country.matches(formatCountry)) return "Country can not have numbers\n";
        return "";
    }   
    
    public static String checkDecription(String dec){
        if(dec.isEmpty()) return "Decription can not null\n";
        if(dec.contains("   ")) return "Decription can not have more than 3 blank\n";
        if(dec.length()>200) return "Decription max length is 200 characters\n";
        return "";
    }
    
    public static String checkModel(String md){
        if(md.isEmpty()) return "Decription can not null\n";
        if(md.contains("   ")) return "Decription can not have more than 3 blank\n";
        if(md.length()>50) return "Decription max length is 50 characters\n";
        return "";
    }
    
    public static String checkYear(String year) {
        String formatYear = "([19|20]\\d{3}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]))"; //yyyy-MM-dd 
        if(year.isEmpty()) return "Year can not null\n";
        if(!year.matches(formatYear)) return "Year must be yyyy-MM-dd (Ex: 2021-02-16)\n";
        return "";
    }
    
    public static String checkCondition(String con){
        if(con.isEmpty()) return "Condition can not null\n";
        if(con.contains("   ")) return "Condition can not have more than 3 blank\n";
        if(con.length()>50) return "Condition max length is 50 characters\n";
        return "";
    }
    
    public static String checkPrice(String price){
        String formatPrice = "^[0-9]*$";
        if(price.isEmpty()) return "Price can not null\n";
        if(price.contains("   ")) return "Price can not have more than 3 blank\n";
        if(!price.matches(formatPrice)) return "Price is wrong (Must be number)\n";
        return "";
    }
    
    public static String checkQuantity(String quantity){
        String formatQu = "^[0-9]*$";
        if(quantity.isEmpty()) return "Price can not null\n";
        if(quantity.contains("   ")) return "Price can not have more than 3 blank\n";
        if(!quantity.matches(formatQu)) return "Quantity is wrong (Must be number)\n";
        return "";
    }
    
    public static String checkWarranty(String wa){
        if(wa.isEmpty()) return "Warranty can not null\n";
        if(wa.contains("   ")) return "Warranty can not have more than 3 blank\n";
        if(wa.length()>50) return "Warranty max length is 50 characters\n";
        return "";
    }
}

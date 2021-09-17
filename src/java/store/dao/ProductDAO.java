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
import java.util.ArrayList;
import store.connection.DBConnection;
import store.dto.ProductDTO;

/**
 *
 * @author DELL
 */
public class ProductDAO implements Serializable{
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
    
    public ProductDTO getProductDetail(String productID) throws Exception
    {
        ProductDTO dto = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Select Price, Quantity, Productname, Description, Manufacturer, Condition, Category, Image from tblProduct where ProductID = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, productID);
                rs = preStm.executeQuery();
                if(rs.next())
                {
                    int price = rs.getInt("Price");
                    int quantity = rs.getInt("Quantity");
                    String name = rs.getString("Productname");
                    String description = rs.getString("Description");
                    String manufacturer = rs.getString("Manufacturer");
                    String condition = rs.getString("Condition");
                    String category = rs.getString("Category");
                    String image = rs.getString("Image");
                    dto = new ProductDTO(productID, name, description, manufacturer, condition, category, image, price, quantity);
                }
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public boolean addProduct(ProductDTO product) throws Exception
    {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Insert into tblProduct(ProductID, ProductName, Description, Manufacturer, Condition, Category, Image, Price, Quantity) values(?,?,?,?,?,?,?,?,?)";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, product.getProductID());
                preStm.setString(2, product.getProductName());
                preStm.setString(3, product.getDescription());
                preStm.setString(4, product.getManufacturer());
                preStm.setString(5, product.getCondition());
                preStm.setString(6, product.getCategory());
                preStm.setString(7, product.getImage());
                preStm.setInt(8, product.getPrice());
                preStm.setInt(9, product.getQuantity());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public ArrayList<ProductDTO> getListProduct() throws Exception
    {
        ArrayList<ProductDTO> list = new ArrayList<>();
        ProductDTO dto = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Select ProductID, Price, Quantity, Productname, Description, Manufacturer, Condition, Category, Image from tblProduct";
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    int price = rs.getInt("Price");
                    int quantity = rs.getInt("Quantity");
                    String name = rs.getString("Productname");
                    String description = rs.getString("Description");
                    String manufacturer = rs.getString("Manufacturer");
                    String condition = rs.getString("Condition");
                    String category = rs.getString("Category");
                    String image = rs.getString("Image");
                    dto = new ProductDTO(productID, name, description, manufacturer, condition, category, image, price, quantity);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public String checkExisted(String productID) throws Exception {
        String result = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "Select ProductID from tblProduct where ProductID = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, productID);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("ProductID");
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public String getProductID() throws Exception 
    { 
        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(14); 
  
        for (int i = 0; i < 14; i++) {
            int index  = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        if(checkExisted(sb.toString()) != null)
        {
            getProductID();
        }
        return sb.toString(); 
    }
}

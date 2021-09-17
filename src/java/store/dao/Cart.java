/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import store.dto.ProductDTO;

/**
 *
 * @author DELL
 */
public class Cart implements Serializable{
    private Map<String,ProductDTO> cart;

    public Cart() {
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }
    
    public void add(ProductDTO dto)
    {
        if(this.cart == null)
        {
           this.cart = new HashMap<>();
        }
        if(this.cart.containsKey(dto.getProductID()))
        {
            int quantity = this.cart.get(dto.getProductID()).getQuantity();
            dto.setQuantity(quantity+1);
        }
        this.cart.put(dto.getProductID(), dto);
    }
    
    public void delete(String id)
    {
        if(this.cart == null)
        {
            return;
        }
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
}

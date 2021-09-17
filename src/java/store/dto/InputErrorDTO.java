/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.dto;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class InputErrorDTO implements Serializable{
    private String productIDErr, productNameErr, manufacturerErr, conditionErr, categoryErr, priceErr, quantityErr, notify;

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getProductIDErr() {
        return productIDErr;
    }

    public void setProductIDErr(String productIDErr) {
        this.productIDErr = productIDErr;
    }

    public String getProductNameErr() {
        return productNameErr;
    }

    public void setProductNameErr(String productNameErr) {
        this.productNameErr = productNameErr;
    }

    public String getManufacturerErr() {
        return manufacturerErr;
    }

    public void setManufacturerErr(String manufacturerErr) {
        this.manufacturerErr = manufacturerErr;
    }

    public String getConditionErr() {
        return conditionErr;
    }

    public void setConditionErr(String conditionErr) {
        this.conditionErr = conditionErr;
    }

    public String getCategoryErr() {
        return categoryErr;
    }

    public void setCategoryErr(String categoryErr) {
        this.categoryErr = categoryErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public InputErrorDTO(String productIDErr, String productNameErr, String manufacturerErr, String conditionErr, String categoryErr, String priceErr, String quantityErr) {
        this.productIDErr = productIDErr;
        this.productNameErr = productNameErr;
        this.manufacturerErr = manufacturerErr;
        this.conditionErr = conditionErr;
        this.categoryErr = categoryErr;
        this.priceErr = priceErr;
        this.quantityErr = quantityErr;
    }

    public InputErrorDTO() {
    }
}

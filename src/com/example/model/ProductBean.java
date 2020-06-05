package com.example.model;

import com.example.da.ProductDataAccess;
import com.example.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBean {
    public List<Product> getProducts() throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().getAllProduct();
    }
}

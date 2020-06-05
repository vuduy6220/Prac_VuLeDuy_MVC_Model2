package com.example.da;

import com.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDataAccess {

    public void createProduct(Product p) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement createStatement = connection
            .prepareStatement("INSERT INTO product (name, pro_desc) VALUES (? ,?)");
        createStatement.setString(1, p.getName());
        createStatement.setString(2, p.getPro_desc());
        createStatement.executeUpdate();
        createStatement.close();
    }

    public PreparedStatement getListStatement() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement listStatement = connection
                .prepareStatement("SELECT * FROM product");
        listStatement.executeQuery();
        return listStatement;
    }

    public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM product");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> products = new LinkedList<>();
        while (resultSet.next()){
            products.add(new Product(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("pro_desc")));
        }
        return products;
    }
}

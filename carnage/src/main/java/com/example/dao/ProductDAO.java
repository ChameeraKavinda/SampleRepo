package com.example.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Product;

public class ProductDAO {
	public void addProduct(Product pro) {
		String query="INSERT INTO Product (name,description,price) Values(?,?,?)";
		
		try {
			Connection connection = DBConnectionFactory.getConnection();
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, pro.getName());
			statement.setString(2, pro.getDescription());
			statement.setDouble(3, pro.getName());
			statement.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List <Product> getAllProducts() throws SQLException{
		List<Product> products =new ArrayList<>();
		String query ="SELECT * FROM Product";
		
		Connection connection=DBConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while(resultSet.next()) {
			int id=resultSet.getInt("product_id");
			String name=resultSet.getString("name");
			String desc=resultSet.getString("description");
			double price=resultSet.getDouble("price");
			
		}
		
	}

}

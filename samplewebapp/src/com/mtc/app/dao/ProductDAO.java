package com.mtc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mtc.app.vo.Product;

public class ProductDAO extends BaseDAO implements IProductDAO{

	private static final String SELECT_QUERY = "select * from test.product";
	private static final String INSERT_RECORD = "insert into test.product values (?,?,?,?,?)";
	private static final String SELECT_ONE_QUERY = "select * from test.product where id=?";
	private static final String UPDATE_RECORD = "update test.product set name=?,price=?,description=?,quantity=? where id=?";
	
	
	@Override
	public Product findById(int id) {
		Product product=new Product();
		try(Connection connection = getConnection()){

			PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY);
            statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> findAll() {

		List<Product> productsList = new ArrayList<>(); 

		try(Connection connection = getConnection()){

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

			while (resultSet.next()) {

				Product product = new Product();

				//transformation code
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));

				productsList.add(product);

			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return productsList;
	}

	@Override
	public boolean add(Product product) {
		
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement(INSERT_RECORD);
			statement.setInt(1, product.getId());
			statement.setString(2, product.getName());
			statement.setFloat(3, product.getPrice());
			statement.setString(4, product.getDescription());
			statement.setInt(5, product.getQuantity());
			statement.execute();
			return true;

		}
		catch (Exception e) {
			
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Product product) {
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement(UPDATE_RECORD);
			statement.setString(1, product.getName());
			statement.setFloat(2, product.getPrice());
			statement.setString(3, product.getDescription());
			statement.setInt(4, product.getQuantity());
			statement.setInt(5, product.getId());
			statement.executeUpdate();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}

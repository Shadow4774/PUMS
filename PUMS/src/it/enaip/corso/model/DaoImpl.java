package it.enaip.corso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoImpl implements UserDao {

	private DaoImpl() {
		
	}
	
	private static class SingletonHelper{
		private static final DaoImpl INSTANCE = new DaoImpl();
	}
	
	public static DaoImpl getInstance() {
		return SingletonHelper.INSTANCE;
	}
	@Override
	public Optional<User> find(String id) throws SQLException {
		String sql = "SELECT user_id, u_name, u_surname, age, department FROM crud_users WHERE user_id = ?";
		int user_id = 0, age = 0;
		String u_name = "", u_surname = "", department = "";
		Connection conn = DataSourceFactory.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			user_id = resultSet.getInt("user_id");
			age = resultSet.getInt("age");
			u_name = resultSet.getString("u_name");
			u_surname = resultSet.getString("u_surname");
			department = resultSet.getString("department");
		}
		return Optional.of(new User(user_id, u_name, u_surname, age, department));
	}

	@Override
	public List<User> findAll() throws SQLException {
		List<User> listUsers = new ArrayList<>();
		String sql = "SELECT user_id, u_name, u_surname, age, department FROM crud_users";
		Connection conn = DataSourceFactory.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int user_id = resultSet.getInt("user_id");
			int age = resultSet.getInt("age");
			String u_name = resultSet.getString("u_name");
			String u_surname = resultSet.getString("u_surname");
			String department = resultSet.getString("department");
			
			User user = new User(user_id, u_name, u_surname, age, department);
			listUsers.add(user);
		}
		return listUsers;
	}

	@Override
	public boolean save(User user) throws SQLException {
		String sql = "INSERT into crud_users (u_name, u_surname, age, department) VALUES (?, ?, ?, ?)";
		boolean inserted = false;
		Connection conn = DataSourceFactory.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getSurname());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getDepartment());
		
		inserted = statement.executeUpdate() > 0;
		return inserted;
	}

	@Override
	public boolean update(User user) throws SQLException {
		String sql = "UPDATE crud_users SET u_name = ?, u_surname = ?, age = ?, department = ? WHERE user_id = ?";
		boolean updated = false;
		Connection conn = DataSourceFactory.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getSurname());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getDepartment());
		statement.setInt(5, user.getId());
		
		updated = statement.executeUpdate() > 0;
		return updated;
	}

	@Override
	public boolean delete(User user) throws SQLException {
		String sql = "DELETE FROM crud_users WHERE user_id = ?";
		boolean deleted = false;
		Connection conn = DataSourceFactory.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, user.getId());
		
		deleted = statement.executeUpdate() > 0;
		return deleted;
	}

}

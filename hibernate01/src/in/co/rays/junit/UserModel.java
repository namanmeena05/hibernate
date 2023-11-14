package in.co.rays.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {
	
	public static Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from user_dto");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public static UserDTO findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user_dto where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserDTO dto = null;

		while (rs.next()) {

			dto = new UserDTO();

			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setSalary(rs.getInt(1));

		}
		return dto;

	}
	
	public static void add(UserDTO bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into user_dto values(?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getSalary());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted " + i);

	}



}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Feature {
	
	public Connection getConnect() {
		try {
			String url= "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "trandailoc123";
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public void Show () {
		String sql = "SELECT * FROM detail";
		Connection connection = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(connection != null) {
			try {
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("fullname")+","+rs.getString("address")+","+rs.getString("phone"));
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void Insert () {
		String fullname, address, phone;
		Scanner sc = new Scanner(System.in);
		System.out.println("fullname: ");
		fullname = sc.nextLine();
		System.out.println("adress: ");
		address = sc.nextLine();
		System.out.println("phone: ");
		phone = sc.nextLine();
		String sql = "INSERT INTO DETAIL VALUES (?,?,?)";
		Connection connection = getConnect();
		PreparedStatement ps = null;
		int rs ;
		if(connection != null) {
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, fullname);
				ps.setString(2,address);
				ps.setString(3,phone);
				rs = ps.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Update () {
		String fullname, address, phone;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select who you want to update (fullname): ");
		fullname = sc.nextLine();
		System.out.println("value update (adress): ");
		address = sc.nextLine();
		System.out.println("value update (phone): ");
		phone = sc.nextLine();
		String sql = "update detail set address = ?, phone = ? where fullname = ?";
		Connection connection = getConnect();
		PreparedStatement ps = null;
		int rs ;
		if(connection != null) {
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, address);
				ps.setString(2, phone);
				ps.setString(3, fullname);
				rs = ps.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Delete () {
		String fullname;
		Scanner sc = new Scanner(System.in);
		System.out.println("select who you want to delete(fullname): ");
		fullname = sc.nextLine();
		String sql = "delete FROM detail where fullname = ?";
		Connection connection = getConnect();
		PreparedStatement ps = null;
		int rs ;
		if(connection != null) {
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, fullname);
				rs = ps.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

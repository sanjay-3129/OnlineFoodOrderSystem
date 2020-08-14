package com.foodorder.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodorder.dao.SecretCodeDAO;

public class SecretCodeDAOImpl implements SecretCodeDAO {
	public static Connection conn = null;

	@Override
	public int setSecretCode(String code) {
		int status = 0;
		try {
			conn = AdminDAOImpl.getConnect();

			PreparedStatement ps = conn.prepareStatement("insert into secretcode values(?,?)");
			ps.setInt(1, 1);
			ps.setString(2, code);

			status = ps.executeUpdate();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("inserting into secretcode table");
		return status;
	}

	@Override
	public String getSecrectCode() {
		
		PreparedStatement ps = null;
		String code = "";
		try {
			conn = AdminDAOImpl.getConnect();
			ps = conn.prepareStatement("select * from secretcode where id=?");
			ps.setInt(1, 1);  //always id will be 1
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				code = res.getString(2);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("getting secret code");
		return code;
	}

	@Override
	public int deleteSecretCode() {
		int status = 0;
		PreparedStatement ps = null;
		try {
			conn = AdminDAOImpl.getConnect();
			ps = conn.prepareStatement("delete from secretcode where id=?");
			ps.setInt(1, 1);
			status = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("deleting secret code");
		return status;
	}

}

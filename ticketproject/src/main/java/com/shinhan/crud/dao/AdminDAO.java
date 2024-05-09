package com.shinhan.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.crud.dto.AdminDTO;
import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.SignoutDTO;
import com.shinhan.crud.util.DBUtil;

public class AdminDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	// 1. 관리자 회원가입
	public int adminSignup(AdminDTO adm) {
		System.out.println(adm);
		int result=0;
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음

		try {
			String sql = "insert into admin values (?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, adm.getId());
			pst.setInt(2, adm.getPw());
			result = pst.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//2. 관리자 로그인
	public AdminDTO adminLogin(LoginDTO login) {
		AdminDTO admin=null;
		conn = DBUtil.dbConnection();
		
		try {
			String sql = "select * from admin where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, login.getId());
			pst.setInt(2, login.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				if(rs.getInt("pw")==(login.getPw())) {
					admin=new AdminDTO();
					admin.setId(rs.getString("id"));
					admin.setPw(rs.getInt("pw"));
				}
				else { //비밀번호 오류
					admin=new AdminDTO();
					admin.setId("-2");
				}
			}
			else { //존재하지 않는 직원
				admin=new AdminDTO();
				admin.setId("-1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return admin;
	}

	//3. 관리자 탈퇴
	public int adminSignout(SignoutDTO signout) {
		int result=0;
		conn = DBUtil.dbConnection();
		
		try {
			String sql = "select * from admin where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, signout.getId());
			pst.setInt(2, signout.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				result= 1; //회원 찾기 성공
				sql="delete from admin where id=? and pw=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, signout.getId());
				pst.setInt(2, signout.getPw());
				pst.executeQuery();
			}
			else {
				result=0; //회원 찾기 실패
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}
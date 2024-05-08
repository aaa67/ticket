package com.shinhan.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.crud.dto.adminDTO;
import com.shinhan.crud.dto.loginDTO;
import com.shinhan.crud.dto.signoutDTO;
import com.shinhan.crud.util.DBUtil;

public class adminDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	// 1. 관리자 회원가입
	public String adminSignup(adminDTO adm) {
		int result = 0;
		String signup=null;
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음

		try {
			String sql = "select * from admin where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, adm.getId());
			rs = pst.executeQuery();
			
			if (rs.next()) {
				signup= "이미 존재하는 아이디입니다.";
			} else {
				sql = "insert into admin values (?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, adm.getId());
				pst.setInt(2, adm.getPw());
				result = pst.executeUpdate();
				if(result>0) {
					signup= "회원가입이 완료되었습니다.";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return signup;
	}
	
	//2. 관리자 로그인
	public adminDTO adminLogin(loginDTO login) {
		adminDTO admin=null;
		conn = DBUtil.dbConnection();
		
		try {
			String sql = "select * from admin where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, login.getId());
			pst.setInt(2, login.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				if(rs.getInt("pw")==(login.getPw())) {
					admin=new adminDTO();
					admin.setId(rs.getString("id"));
					admin.setPw(rs.getInt("pw"));
				}
				else { //비밀번호 오류
					admin=new adminDTO();
					admin.setId("-2");
				}
			}
			else { //존재하지 않는 직원
				admin=new adminDTO();
				admin.setId("-1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return admin;
	}

	//3. 관리자 탈퇴
	public int adminSignout(signoutDTO signout) {
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
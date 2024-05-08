package com.shinhan.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.crud.dto.loginDTO;
import com.shinhan.crud.dto.signoutDTO;
import com.shinhan.crud.dto.userDTO;
import com.shinhan.crud.util.DBUtil;
import com.shinhan.crud.util.DateUtil;

public class userDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	


	// 1. 고객 회원가입
	public String userSignup(userDTO user) {
		int result = 0;
		String signup = null;
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음

		try {
			String sql = "select * from member where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getId());
			rs = pst.executeQuery();

			if (rs.next()) {
				signup = "이미 존재하는 아이디입니다.";
			} else {
				sql = "insert into member values (?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, user.getId());
				pst.setInt(2, user.getPw());
				pst.setString(3, user.getName());
				pst.setString(4, user.getAddress());
				pst.setDate(5, user.getBirth());
				result = pst.executeUpdate();
				if (result > 0) {
					signup = "회원가입이 완료되었습니다.";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return signup;
	}

	// 2. 고객 로그인
	public userDTO userLogin(loginDTO login) {
		userDTO user=null;
		conn = DBUtil.dbConnection();
		
		try {
			String sql = "select * from admin where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, login.getId());
			pst.setInt(2, login.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				if(rs.getInt("pw")==(login.getPw())) {
					user=new userDTO();
					user.setId(rs.getString("id"));
					user.setPw(rs.getInt("pw"));
					user.setName(rs.getString("name"));
					user.setAddress(rs.getString("address"));
					user.setBirth(DateUtil.getSQLDate(rs.getString("birth")));
					//user.set
				}
				else { //비밀번호 오류
					user=new userDTO();
					user.setId("-2");
				}
			}
			else { //존재하지 않는 직원
				user=new userDTO();
				user.setId("-1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return user;
	}

	//3. 고객 탈퇴
	public int userSignout(signoutDTO signout) {
		int result=0;
		conn = DBUtil.dbConnection();
		
		try {
			String sql = "select * from member where id=? and pw=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, signout.getId());
			pst.setInt(2, signout.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				result= 1; //회원 찾기 성공
				sql="delete from member where id=? and pw=?";
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

	//4. 고객 정보 수정: 비밀번호 수정
	public int updatePw(String userId, int pw) {
		int result = 0;
		String sql = "update member set pw=? where id=?";
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pw);
			pst.setString(2, userId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	//5. 고객 정보 수정: 주소 수정
	public int updateAd(String userId, String ad) {
		int result = 0;
		String sql = "update member set address=? where id=?";
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ad);
			pst.setString(2, userId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}
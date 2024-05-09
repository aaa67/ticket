package com.shinhan.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.crud.dto.showDTO;
import com.shinhan.crud.util.DBUtil;
import com.shinhan.crud.util.DateUtil;

public class showDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	// 1. 공연 추가
	public String addshow(showDTO show) {
		String result = null;
		String sql = "insert into show(id, performer, name, time, location, age, image) values (show_seq.nextval,?,?,TO_TIMESTAMP(?),?,?,?)";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, show.getPerformer());
			pst.setString(2, show.getName());
			pst.setString(3, show.getTime());
			pst.setString(4, show.getLocation());
			pst.setInt(5, show.getAge());
			pst.setString(6, show.getImage());
			if (pst.executeUpdate() > 0) {
				result = "공연이 추가되었습니다.";
			} // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 2. 전체 공연 조회
	public List<showDTO> selectAllShow() {
		List<showDTO> showList = new ArrayList<showDTO>();
		String sql = "select * from show";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				showDTO show = makeShow(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return showList;
	}

	// 3. 예매 오픈 전 공연 조회
	public List<showDTO> selectClosedShow() {
		List<showDTO> showList = new ArrayList<showDTO>();
		String sql = "select * from show where status='예매 오픈 전'";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				showDTO show = makeShow(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return showList;
	}

	// 3. 공연 오픈 처리
	public int openShow(int showId) {
		int result = 0;
		String sql = "update show set status='예매 가능' where id=? ";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 4. 예매 오픈 중이거나 매진인 공연 조회
	public List<showDTO> selectOpenedShow() {
		List<showDTO> showList = new ArrayList<showDTO>();
		String sql = "select * from show where status='예매 가능' or status='매진'";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				showDTO show = makeShow(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return showList;
	}

	// 5. 공연 예매 마감 처리
	public int closeShow(int showId) {
		int result = 0;
		String sql = "update show set status='예매 마감' where id=? ";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 6. 가수명/공연명으로 공연 검색
	public List<showDTO> selectByName(String name) {
		List<showDTO> showList = new ArrayList<showDTO>();
		String sql = "select * from show where lower(performer)=? or lower(name)=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name.toLowerCase());
			pst.setString(2, name.toLowerCase());
			rs = pst.executeQuery();
			while (rs.next()) {
				showDTO show = makeShow(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return showList;
	}

	// 공연 DTO 생성
	private showDTO makeShow(ResultSet rs) throws SQLException {
		showDTO show = new showDTO();

		// time: timestamp->string 변환
		//String timeStr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(rs.getTimestamp("time"));
		

		show.setId(rs.getInt("id"));
		show.setPerformer(rs.getString("performer"));
		show.setName(rs.getString("name"));
		show.setTime(DateUtil.timestampToString(rs.getTimestamp("time")));
		show.setLocation(rs.getString("location"));
		show.setAge(rs.getInt("age"));
		show.setStatus(rs.getString("status"));
		show.setImage(rs.getString("image"));

		return show;
	}

}
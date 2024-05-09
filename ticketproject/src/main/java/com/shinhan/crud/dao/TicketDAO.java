package com.shinhan.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.crud.dto.MyticketDTO;
import com.shinhan.crud.dto.SeatDTO;
import com.shinhan.crud.util.DBUtil;
import com.shinhan.crud.util.DateUtil;

public class TicketDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	// 1. 사용자 나이 계산
	public int userAge(String userId) {
		int age = 0;
		String sql = "SELECT TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE), member.birth) / 12) age FROM member";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				age = rs.getInt("age");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return age;
	}

	// 2. show.status='예매 가능'인지, 관람 가능 연령인지 확인
	public int checkShow(int showId, String userId) {
		int result = 0;
		String sql = "select * from show join where id=? and age<=? and status='예매 가능'";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			pst.setInt(2, userAge(userId));
			rs = pst.executeQuery(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 3. 해당 공연 좌석 목록 반환
	public List<SeatDTO> selectByShow(int showId) {
		List<SeatDTO> seatList = new ArrayList<SeatDTO>();
		String sql = "select * from ticket t join seat s on t.seat_id=s.id where t.show_id=? order by t.id asc";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			rs = pst.executeQuery();
			while (rs.next()) {
				SeatDTO seat = makeSeat(rs);
				seatList.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return seatList;
	}

	// 4. 예매 가능한 좌석인지 확인
	public int checkSeat(int showId, String[] seatArr) {
		int result = 0;
		String sql = "select seat_id, status from ticket t left outer join seat s on t.seat_id=s.id "
				+ " where show_id=? and area=? and seat=? ";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			pst.setString(2, seatArr[0]);
			pst.setInt(3, Integer.parseInt(seatArr[1].substring(0, 1)));
			rs = pst.executeQuery(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
			if (rs.next()) {
				if (rs.getString("status").equals("1")) { // 예매 가능한 경우
					result = rs.getInt("seat_id"); // 좌석 번호 반환
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 5. 티켓 예매
	public int plusTicket(int showId, String userId, int seatId) {
		int result = 0;
		String sql = "update ticket set member_id=?, time=TO_TIMESTAMP(SYSDATE), status='0' where show_id=? and seat_id=?";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			pst.setInt(2, showId);
			pst.setInt(3, seatId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 좌석 DTO 만들기
	private SeatDTO makeSeat(ResultSet rs2) throws SQLException {
		SeatDTO seat = new SeatDTO();

		seat.setArea(rs.getString("area"));
		seat.setSeat(rs.getInt("seat"));
		seat.setStatus(rs.getString("status").equals("1") ? "예매 가능" : "예매 불가능");
		return seat;
	}

	// 6. 마이페이지 예매내역 조회
	public List<MyticketDTO> myTicket(String userId) {
		List<MyticketDTO> ticketList = new ArrayList<MyticketDTO>();
		String sql = "select t.id \"예매 번호\", sh.performer 가수명, sh.name 공연명, sh.time 공연일자, sh.location 장소, se.area 구역, se.seat 번호, se.price 가격 "
				+ " from ticket t join show sh on t.show_id=sh.id " + "              join seat se on t.seat_id=se.id "
				+ " where t.member_id=? order by \"예매 번호\" asc";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				MyticketDTO ticket = makeMyTicket(rs);
				ticketList.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return ticketList;
	}

	// 7. 마이페이지 티켓 예매 취소
	public int cancelTicket(int ticketId) {
		int result = 0;
		int showId=0;
		String sql = "update ticket set member_id=null, time=null, status='1' where id=?";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ticketId);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
			if(result>0) {
				sql = "select show_id 공연번호 from ticket where id=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, ticketId);
					rs = pst.executeQuery();
					while (rs.next()) {
						showId=rs.getInt("공연번호");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.dbDisconnect(conn, pst, rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return showId;
	}

	// 8. 예매시마다 공연 status 값 업데이트
	public void updateShowStatus1(int showId) {
		int result = 0;
		String sql = "select count(*) 좌석수 from ticket where show_id=? and status='1'";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt("좌석수");
			}
			if (result == 0) {
				sql = "update show set status='매진' where id=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, showId);
					pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.dbDisconnect(conn, pst, rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
	}

	// 9. 매진 공연 예매 취소 시 공연 stauts 값 업데이트
	public void updateShowStatus2(int showId) {
		int result=0;
		String status=null;
		String sql = "select count(*) 좌석수, s.status 공연예매가능여부 from ticket t join show s on(t.show_id=s.id) "
				+ " where t.show_id=? and t.status='1' group by s.status";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, showId);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt("좌석수");
				status=rs.getString("공연예매가능여부");
			}
			if (result > 0 && status.equals("매진")) {
				sql = "update show set status='예매 가능' where id=? and status='매진'";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, showId);
					pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.dbDisconnect(conn, pst, rs);
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
		}

	// myticketDTO 만들기
	private MyticketDTO makeMyTicket(ResultSet rs) throws SQLException {
		MyticketDTO ticket = new MyticketDTO();

		ticket.setTicketNum(rs.getInt("예매 번호"));
		ticket.setPerformer(rs.getString("가수명"));
		ticket.setName(rs.getString("공연명"));
		ticket.setTime(DateUtil.timestampToString(rs.getTimestamp("공연일자")));
		ticket.setLocation(rs.getString("장소"));
		ticket.setArea(rs.getString("구역"));
		ticket.setSeat(rs.getInt("번호"));
		ticket.setPrice(rs.getInt("가격"));

		return ticket;
	}

}

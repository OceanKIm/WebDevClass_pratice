package com.koreait.board2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.koreait.board2.db.BoardDAO;
import com.koreait.board2.db.SQLInterUpdate;
import com.koreait.board2.model.BoardCmtVO;
import com.koreait.board2.model.BoardVO;

public class BoardService {
	
	// 전역 application 저장소
	static ServletContext application;
	
	public static int selPageCnt(BoardVO param) {
		return BoardDAO.selPageCnt(param);
	}
	
	public static int regmod(BoardVO param) {
		if (param.getI_board() > 0 ) {
			
			String sql = " update t_board_? "
					+ " set title = ?, ctnt = ?, m_dt = now() "
					+ " where i_board = ? ";
			return BoardDAO.myExecuteUpdate(sql, new SQLInterUpdate() {			
				@Override
				public void proc(PreparedStatement ps) throws SQLException {
					ps.setInt(1, param.getTyp());
					ps.setNString(2, param.getTitle());
					ps.setNString(3, param.getCtnt());
					ps.setInt(4, param.getI_board());
				}
			});
		} else {
			return BoardDAO.insBoard(param);
		}
	}
	
	
	public static List<BoardVO> selBoardList(BoardVO param, int page) {
		param.setS_IDx((page - 1) * param.getGetRowCntPerPage());
		return BoardDAO.selBoardList(param);
	}


	

	public static BoardVO detail(BoardVO param, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		System.out.println("요청 IP = " + ip);
		String key = String.format("log_%d_%d", param.getTyp(), param.getI_board());
		System.out.println("key = " + key);
		
		application = request.getServletContext();
		String loadIp = (String)application.getAttribute(key);	// getAttribute 로 받는 것을 기억!
		
		// null pointer excetion 조심!
		if (!ip.equals(loadIp)) {
			// 처음 접속 할때만 
			String sql = " update t_board_? "
					+ " set views = views + 1 "
					+ " where i_board = ? ";
			BoardDAO.myExecuteUpdate(sql, new SQLInterUpdate() {
				@Override
				public void proc(PreparedStatement ps) throws SQLException {
					ps.setInt(1, param.getTyp());
					ps.setInt(2, param.getI_board());
				}
			});
			application.setAttribute(key, ip);
		}
		
		System.out.println("<< 조회 기록 >> ");
		Enumeration<String> enu = application.getAttributeNames();
		while(enu.hasMoreElements()) {
			String str = enu.nextElement();
			if (str.startsWith("log_")) {
				String val = (String)application.getAttribute(str);
				System.out.println("key = " + str + "ip : " + val);
			}
			
		}
		return BoardDAO.selBoard(param);
	}
	
	public static int delBoard(BoardVO param) {
		
		String sql = " delete from t_board_? "
				+ "	where i_board = ? ";
		return BoardDAO.myExecuteUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getTyp());
				ps.setInt(2, param.getI_board());
			}
		});
	}
	
	public static int cmtIns(BoardCmtVO param) {
		String sql = " insert into t_board_cmt_? (i_board, ctnt) "
				+ " values (?, ?) ";
		return BoardDAO.myExecuteUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getTyp());
				ps.setInt(2, param.getI_board());
				ps.setNString(3, param.getCtnt());
			}
		});
	}
	
	public static List<BoardCmtVO> selBoardCmtList (BoardVO param) {
		return BoardDAO.selBoardCmtList(param);
	}
	
	// 공감 비공감.	
	public static int empOrUnemp(BoardCmtVO param, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();	// 요청 IP
		String key = String.format("log_%d_%d_%d", param.getTyp(), param.getI_board(), param.getI_cmt()); //요청 key
		String loadIp = (String) application.getAttribute(key);
		if (!ip.equals(loadIp)) {
			application.setAttribute(key, ip);
			String sql = " update t_board_cmt_? "
					+ " set emp = emp + ?, unemp = unemp + ? "
					+ " where i_cmt = ? ";
			return BoardDAO.myExecuteUpdate(sql, new SQLInterUpdate() {
				@Override
				public void proc(PreparedStatement ps) throws SQLException {
					ps.setInt(1, param.getTyp());
					ps.setInt(2, param.getEmp());
					ps.setInt(3, param.getUnemp());
					ps.setInt(4, param.getI_cmt());
				}
			});
		}
		return 0;
	}
	
	
	
	// 폐기예정
	public static int regI_board(BoardVO param) {
		return BoardDAO.regI_board(param);
	}
}





















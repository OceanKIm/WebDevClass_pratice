package com.koreait.board3.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLInterUpdate {
	void proc(PreparedStatement ps) throws SQLException;
}

package com.koreait.board4.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLInterUpdate {
	void proc(PreparedStatement ps) throws SQLException;
}


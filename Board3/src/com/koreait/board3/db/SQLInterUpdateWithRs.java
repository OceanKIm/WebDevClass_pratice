package com.koreait.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 폐기예정.
public interface SQLInterUpdateWithRs {
	void proc(PreparedStatement ps, ResultSet rs, Connection con) throws SQLException;
}


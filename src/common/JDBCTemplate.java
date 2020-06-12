package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

////// Connection & Close & Commit & rollback  4揶쏆뮆彛� user揶쏉옙 占쎌젫占쎈선占쎈막 占쎈땾 占쎌뿳野껓옙 筌띾슢諭억옙堉깍옙紐�
public class JDBCTemplate {
	// 占쎈염野껉퀬釉� 占쎄맒占쎄묶嚥∽옙 �뵳�뗪쉘占쎈퉸雅뚯눊荑뗰옙�뼄.
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@192.168.0.249:1521:XE";
		String id = "MPJ_CURD";
		String pwd = "admin1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 占쎈염野껓옙 揶쏆빘猿쒐몴占� 獄쏆룇釉섓옙苑�(占쎈염野껉퀬釉� 占쎄맒占쎄묶�몴占�) close()占쎈릭野껋쥓�뼄.
	public static void Close(Connection con) {
		try {
			if (!con.isClosed() && con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

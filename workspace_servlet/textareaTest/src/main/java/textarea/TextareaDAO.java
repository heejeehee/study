package textarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextareaDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private String user = "scott4_5";
	private String password = "tiger";

	private Connection connDB() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 내용 삽입
	public int insertText(String title, String msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = -1;	// 데이터베이스 접근 오류

		try {

			conn = connDB();
			String sql = "";
			sql += " INSERT INTO textarea (text_seq, title, text_info)";
			sql += " VALUES (text_seq.NEXTVAL, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, msg);

			int rowsAffected = ps.executeUpdate();	// 삽입된 값의 수
            if (rowsAffected > 0) {
                result = 1; // 성공적으로 삽입됨을 나타내는 값
            } else {
                result = 0; // 삽입된 행이 없음을 나타내는 값
            }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	
	public List<String> titles = new ArrayList<String>();
	public List<Integer> seqs = new ArrayList<Integer>();
	public Map<String, String> map = new HashMap<String, String>();
	

	// 메인페이지
	public int mainSelect() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;	// 데이터베이스 접근 오류
		
		try {

			conn = connDB();
			
			String sql = " select text_seq, title from textarea";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();	// SQL 실행
            while(rs.next()) {
            	int seq = rs.getInt("text_seq");
            	String title = rs.getString("title");
            	System.out.println(seq);
            	System.out.println(title);
            	seqs.add(seq);
            	titles.add(title);
            	result = 1;		// 데이터 읽기 성공
            }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	
	// 내용상세보기
	public int mainDetailSelect(int text_seq) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;	// 데이터베이스 접근 오류
		
		try {
			
			conn = connDB();
			
			String sql = " select * from textarea";
			sql += " where text_seq = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, text_seq);
			
			rs = ps.executeQuery();	// SQL 실행
			while(rs.next()) {
				String seq = rs.getString("text_seq");
				String title = rs.getString("title");
				String text_info = rs.getString("text_info");
				System.out.println("seq : " + seq + "title : " + title + ", text_info : " + text_info);
				map.put("seq", seq);
				map.put("title", title);
				map.put("text_info", text_info);
				
				result = 1;		// 데이터 읽기 성공
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 수정하기
		public int textUpdate(String title, String msg, String seq) {
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int result = -1;	// 데이터베이스 접근 오류
			
			try {
				
				conn = connDB();
				
				String sql = " UPDATE textarea";
					   sql += " SET title = ?, text_info = ?";
					   sql += " WHERE text_seq = ?";
				
				int cvSeq = Integer.parseInt(seq);
					   
				ps = conn.prepareStatement(sql);
				ps.setString(1, title);
				ps.setString(2, msg);
				ps.setInt(3, cvSeq);
				
				int rowsAffected = ps.executeUpdate();	// 삽입된 값의 수
	            if (rowsAffected > 0) {
	                result = 1; // 성공적으로 삽입됨을 나타내는 값
	            } else {
	                result = 0; // 삽입된 행이 없음을 나타내는 값
	            }
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}
}

package sec03.brd08.paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {

	// 목록 조회
	public List<EmpDTO> selectEmp(int start, int end) {
		List<EmpDTO> list = new ArrayList<EmpDTO>();

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = "";
			query += " select * from (";
			query += "     select rownum rnum, t1.* from (";
			query += "         with emp_recu (lv, empno, mgr, ename) as (";
			query += "             select";
			query += "                 1 as lv,";
			query += "                 empno, mgr, ename";
			query += "             from emp4";
			query += "             where mgr is null";
			query += "             union all";
			query += "             select";
			query += "                 er.lv + 1 as lv,";
			query += "                 e.empno, e.mgr, e.ename";
			query += "             from emp_recu er";
			query += "             left outer join emp4 e on e.mgr = er.empno";
			query += "             where e.mgr is not null";
			query += "         )";
			query += "         search depth first by empno desc set sort_empno";
			query += "         select * from emp_recu";
			query += "         order by sort_empno";
			query += "     ) t1";
			query += " ) t2";
			query += " where rnum >= ? and rnum <= ?";

//			ps = con.prepareStatement(query);
			ps = new LoggableStatement(con, query);
			ps.setInt(1, start);
			ps.setInt(2, end);

			
			
			System.out.println( ( (LoggableStatement)ps ).getQueryString() );
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();

				dto.setEmpno(rs.getInt("EMPNO"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setLv(rs.getInt("lv"));
				dto.setRnum(rs.getInt("rnum"));

				list.add(dto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;
	}
	
	// 전체 개수 조회
	public int selectTotalEmp() {
		int totalCount = -1;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "";
			query += " select count(*) as cnt from emp4";
			
			ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return totalCount;
	}
}

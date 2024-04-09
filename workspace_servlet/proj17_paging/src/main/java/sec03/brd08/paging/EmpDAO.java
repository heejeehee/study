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

	// 전체 목록 조회
	public List<EmpDTO> selectEmp() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();

		Connection con = null;
		PreparedStatement ps = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = " select * from emp4 ";

			ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();

				dto.setLv(0);
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));
				
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

	    ////////////////
		return list;  //
	}   ////////////////

	////////////////////////////////////////////////////////////
	//														  //
	////////////////////////////////////////////////////////////
	
	// 부분 목록 조회
	public List<EmpDTO> separateEmp(int pageNum) {
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
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, pageNum * 5 - 4);
			ps.setInt(2, pageNum * 5);


			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();

				dto.setLv(rs.getInt("lv"));
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));

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

		////////////////
		return list;  //
	}   ////////////////
	
	//////////////////////////////////////////////////////////////////
	
	// 페이지 갯수 정하기
	/*
	 * 전체 컬럼 갯수를
	 * 오라클 select문의 rownum을 이용해서 가져와서
	 * 5개씩 보여줄 예정이니까
	 * ((전체수 나누기 5) + 나머지가 있으면 + 1) = 페이지 수가 된다.
	 * ex) 전체수 112일 경우 : (112 / 5) + (112 % 5) = 22 + 1 = 23 페이지
	 */
	public int pageSetting() {
		/* EmpDTO empDTO = new EmpDTO(); */
		int count = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = "";
			
			query += " SELECT rnum FROM";
			query += " (SELECT rownum rnum, t1.* FROM";
			query += " 	(WITH emp_recu (lv, empno, ename, mgr) AS (";
			query += " 		SELECT";
			query += " 			1 AS lv,";
			query += " 			empno,";
			query += " 			ename,";
			query += " 			mgr";
			query += " 		FROM";
			query += " 			emp4";
			query += " 		WHERE mgr IS NULL";
			query += " 		UNION ALL";
			query += " 		SELECT";
			query += " 			er.lv + 1 AS lv,";
			query += " 			e.empno,";
			query += " 			e.ename,";
			query += " 			e.mgr";
			query += " 		FROM";
			query += " 			EMP_recu er";
			query += " 		LEFT OUTER JOIN emp4 e ON e.mgr = er.empno";
			query += " 		WHERE e.mgr IS NOT NULL";
			query += " 	)";
			query += " 	SEARCH DEPTH FIRST BY empno DESC SET sort_emp";
			query += " 	SELECT * FROM EMP_RECU";
			query += " 	ORDER BY sort_emp";
			query += " 	) t1";
			query += " )t2";
			
			ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count++;	// 1행당 +1
			}
			/* int result = empDTO.setPages(count); */

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

		////////////////
		return count; //
	}   ////////////////
	
	
	
	
	// 계층별 정렬
	public List<EmpDTO> selectDepthEmp() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();

		Connection con = null;
		PreparedStatement ps = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = "";
			
			query += " WITH emp_recu (lv, empno, ename, mgr) AS (";
			query += " 		SELECT";
			query += " 			1 AS lv,";
			query += " 			empno,";
			query += " 			ename,";
			query += " 			mgr";
			query += " 		FROM EMP4";
			query += " 		WHERE mgr IS NULL";
			query += " 		UNION ALL";
			query += " 		SELECT";
			query += " 			er.lv + 1 AS lv,";
			query += " 			e.empno,";
			query += " 			e.ename,";
			query += " 			e.mgr";
			query += " 		FROM emp_recu er";
			query += " 		LEFT OUTER JOIN emp4 e ON e.mgr = er.empno";
			query += " 		WHERE e.mgr IS NOT NULL";
			query += " 	)";
			query += " 	SEARCH DEPTH FIRST BY empno DESC SET sort_empno";
			query += " 	SELECT * FROM emp_recu";
			query += " 	ORDER BY sort_empno";
			
			

			ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				
				dto.setLv(rs.getInt("lv"));
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));

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

	    ////////////////
		return list;  //
	}   ////////////////
	
	
	
	

}

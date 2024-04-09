package sec03.brd08.paging;

import java.util.List;

public class EmpService {

	// DAO를 호출하는 메서드
	List<EmpDTO> listEmp() {
		
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.selectEmp();
		
		return list;
		
	}
	
	// EmpDAO 의 separateEmp 를 호출하는 메서드
	List<EmpDTO> pageList(int pageNum) {
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.separateEmp(pageNum);
		
		return list;
	}
	
	// 페이지 갯수 전달하는 메서드
	int pageSetting() {
		EmpDAO empDAO = new EmpDAO();
		int pageSet = empDAO.pageSetting();
		
		return pageSet;
	}
	
	// 계층별로 보는 메서드
	List<EmpDTO> listSortEmp() {
		
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.selectDepthEmp();
		
		return list;
		
	}
}

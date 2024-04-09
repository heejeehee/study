package sec03.brd08.paging;

import java.util.List;

public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();

	List<EmpDTO> listEmp(int pageNum, int countPerPage){
		
		int start = 0, end = 0;
		// start : ( (2-1)*5 )+1
		// end : 2 * 5
		
		start = ( (pageNum-1) * countPerPage ) + 1;
		end = pageNum * countPerPage;
		
		List list = empDAO.selectEmp(start, end);
		
		return list;
	}
	
	int getTotalEmp() {
		
		return empDAO.selectTotalEmp();
		
	}
}

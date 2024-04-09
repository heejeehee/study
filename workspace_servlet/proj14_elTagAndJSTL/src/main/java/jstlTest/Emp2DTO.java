package jstlTest;

import java.lang.invoke.StringConcatFactory;

public class Emp2DTO {
	String ename;
	int empno;
	int sal;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Emp2DTO [ename=" + ename + ", empno=" + empno + ", sal=" + sal + "]";
	}
}

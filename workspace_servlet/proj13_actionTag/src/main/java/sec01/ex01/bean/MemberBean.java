package sec01.ex01.bean;

public class MemberBean {
	
	public MemberBean(){
		System.out.println("MemberBean 생성");
	}
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public String getId() {
		System.out.println("getId 실행 [id값] : " + this.id);
		return id;
	}
	public void setId(String id) {
		System.out.println("setId 실행 [id값] : " + id);
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setpwd2(String pwd) {
		System.out.println("setpwd2 실행 [pwd값] : " + pwd);
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

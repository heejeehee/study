package sec01.ex01;

public class MemberBean {
	
	public MemberBean(){
		System.out.println("MemberBean 생성");
	}

	private String id;
	private String pwd;
	private String name;
	private String email;
	/**
	 * @return the id
	 */
	public String getId() {
		System.out.println("getId 실행 this.id : "+ this.id);
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		System.out.println("setId 실행 id : "+ id);
		this.id = id;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		System.out.println("setpwd 실행");
		this.pwd = pwd;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

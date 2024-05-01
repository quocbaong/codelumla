package entity;

public class Login {
	private String user;
	private String mk;
	public Login(String user, String mk) {
		super();
		this.user = user;
		this.mk = mk;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
}

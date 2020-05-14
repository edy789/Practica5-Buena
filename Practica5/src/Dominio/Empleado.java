package Dominio;

public class Empleado {
	private String loggin;
	private String password;

	
	public Empleado(String loggin, String password) {
		super();
		this.loggin = loggin;
		this.password = password;
	}

	public String getLoggin() {
		return loggin;
	}

	public void setLoggin(String loggin) {
		this.loggin = loggin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Empleado [loggin=" + loggin + ", password=" + password + "]";
	}
	
	
}

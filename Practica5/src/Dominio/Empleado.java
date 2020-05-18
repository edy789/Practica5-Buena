package Dominio;

import java.util.ArrayList;

import Persistencia.EmpleadoDao;

public class Empleado {
	private String loggin;
	private String password;
	private EmpleadoDao empleadoDao;
	
	public Empleado(String loggin, String password) {
		this.loggin = loggin;
		this.password = password;
		empleadoDao= new EmpleadoDao();
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
	
	public void insertar() throws ClassNotFoundException {
		empleadoDao.insertar(this);
	}

	public ArrayList<Empleado> leerTodos() throws ClassNotFoundException {
		return empleadoDao.leerTodos();

	}
	public Empleado leerPersona(String loggin) throws ClassNotFoundException {
		return empleadoDao.leer(loggin);

	}

	public void actualizar(String loggin) throws ClassNotFoundException {
		empleadoDao.actualizar(this, loggin);

	}

	public void eliminar() throws ClassNotFoundException {
		empleadoDao.eliminar(this);
	}

	public void eliminarTodo() throws ClassNotFoundException {
		empleadoDao.eliminarTodo();

	}
	
}

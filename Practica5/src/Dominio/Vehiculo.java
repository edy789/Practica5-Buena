package Dominio;

import java.util.ArrayList;

public abstract class Vehiculo {
	private static String matricula;
	private static String marca;
	private static String modelo;
	private String color;
	private static double precio;
	
	public Vehiculo(String matricula, String marca, String modelo, String color, double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}
	public Vehiculo() {
	}

	public static String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public static String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public static String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", precio=" + precio + "]";
	}
	
	abstract public boolean insertar() throws ClassNotFoundException ;
	abstract public ArrayList<Vehiculo> leerTodos() throws ClassNotFoundException ;
	abstract public Vehiculo leerVehiculo(String matricula) throws ClassNotFoundException;
	abstract public void actualizar(String matricula) throws ClassNotFoundException ;
	abstract public void eliminar() throws ClassNotFoundException;
	abstract public void eliminarTodo() throws ClassNotFoundException;
	
}

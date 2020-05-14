package Dominio;

import java.util.ArrayList;

public class VehiculoTurismos extends Vehiculo {
	private int numpuertas;

	public VehiculoTurismos(String matricula, String marca, String modelo, String color, double precio,
			int numpuertas) {
		super(matricula, marca, modelo, color, precio);
		this.numpuertas = numpuertas;
	}

	public int getNumpuertas() {
		return numpuertas;
	}

	public void setNumpuertas(int numpuertas) {
		this.numpuertas = numpuertas;
	}

	@Override
	public void insertar() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Vehiculo> leerTodos() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo leerPersona(String matricula) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(String matricula) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTodo() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

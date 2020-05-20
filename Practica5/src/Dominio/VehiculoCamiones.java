package Dominio;

import java.util.ArrayList;
import Persistencia.ExtrasVehiTurismosDao;
import Persistencia.VehiculoCamionesDao;

public class VehiculoCamiones extends Vehiculo{
	private double capacarga;
	private VehiculoCamionesDao vehiculoCamionesDao;

	public VehiculoCamiones(String matricula, String marca, String modelo, String color, double precio,
			double capacarga) {
		super(matricula, marca, modelo, color, precio);
		this.capacarga = capacarga;
	}
	public VehiculoCamiones() {
		
	}

	public double getCapacarga() {
		return capacarga;
	}

	public void setCapacarga(double capacarga) {
		this.capacarga = capacarga;
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

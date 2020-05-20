package Dominio;

import java.util.ArrayList;
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
		vehiculoCamionesDao.insertar(this);
		
	}
	@Override
	public ArrayList<Vehiculo> leerTodos() throws ClassNotFoundException {
		return vehiculoCamionesDao.leerTodos();
	}
	@Override
	public Vehiculo leerPersona(String matricula) throws ClassNotFoundException {
		return vehiculoCamionesDao.leer(matricula);
	}
	@Override
	public void actualizar(String matricula) throws ClassNotFoundException {
		vehiculoCamionesDao.actualizar(this, matricula);
	}
	@Override
	public void eliminar() throws ClassNotFoundException {
		vehiculoCamionesDao.eliminar(this);
	}
	@Override
	public void eliminarTodo() throws ClassNotFoundException {
		vehiculoCamionesDao.eliminarTodo();
		
	}
	
	
	

	
}

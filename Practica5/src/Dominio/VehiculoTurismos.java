package Dominio;

import java.util.ArrayList;
import Persistencia.ExtrasVehiTurismosDao;
import Persistencia.VehiculoTurismoDao;

public class VehiculoTurismos extends Vehiculo {
	private int numpuertas;
	private ExtrasVehiTurismos extras;
	private VehiculoTurismoDao vehiculoTurismoDao;

	public VehiculoTurismos(String matricula, String marca, String modelo, String color, double precio, int numpuertas,
			ExtrasVehiTurismos extras) {

		super(matricula, marca, modelo, color, precio);
		this.numpuertas = numpuertas;
		this.extras = extras;
	}
	
	public VehiculoTurismos() {
		
	}

	public int getNumpuertas() {
		return numpuertas;
	}

	public void setNumpuertas(int numpuertas) {
		this.numpuertas = numpuertas;
	}

	public ExtrasVehiTurismos getExtras() {
		return extras;
	}

	public void setExtras(ExtrasVehiTurismos extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "VehiculoTurismos [numpuertas=" + numpuertas + ", extras=" + extras + "]";
	}

	@Override
	public void insertar() throws ClassNotFoundException {
		VehiculoTurismosDao.insertar(this);
		
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
		VehiculoTurismosDao.eliminarTodo();
		
	}

	@Override
	public void eliminarTodo() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

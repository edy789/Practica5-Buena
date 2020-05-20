package Dominio;

import java.util.ArrayList;
import Persistencia.ExtrasVehiTurismosDao;
import Persistencia.VehiculoCamionesDao;
import Persistencia.VehiculoTurismoDao;

public class VehiculoTurismos extends Vehiculo {
	private int numpuertas;
	private ExtrasVehiTurismos extras;
	private VehiculoTurismoDao vehiculoTurismoDao;

	public VehiculoTurismos(String matricula, String marca, String modelo, String color, double precio, int numpuertas, ExtrasVehiTurismos extras) {
		super(matricula, marca, modelo, color, precio);
		this.numpuertas = numpuertas;
		this.extras = extras;
		vehiculoTurismoDao = new VehiculoTurismoDao();
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
		return VehiculoTurismosDao.leerTodos();
	}

	@Override
	public Vehiculo leerPersona(String matricula) throws ClassNotFoundException {
		return VehiculoTurismosDao.leer(matricula);
	}

	@Override
	public void actualizar(String matricula) throws ClassNotFoundException {
		VehiculoTurismosDao.actualizar(this, matricula);
	}

	@Override
	public void eliminar() throws ClassNotFoundException {
		VehiculoTurismosDao.eliminar(this);	
	}

	@Override
	public void eliminarTodo() throws ClassNotFoundException {
		VehiculoTurismosDao.eliminarTodo();
	}
	
	
	
}

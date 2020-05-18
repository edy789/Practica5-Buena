package Persistencia;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Vehiculo;



public class VehiculoTurismoDao extends VehiculoDao{

	@Override
	public boolean insertar(Vehiculo vehiculo) throws ClassNotFoundException {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Turismos values ('"+profesor.getDNI()+"','"+profesor.getNombre()+"','"+profesor.getApellidos()+"',"+profesor.getEdad()+")";
		String sql2="INSERT INTO Profesores6 values ('"+profesor.getDNI()+"',"+((Profesor)profesor).getSueldo()+")";

		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			stm.execute(sql2);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ProfesorDaoImple, método registrar");
			e.printStackTrace();
		}
		
		
		return registrar;
	}


	@Override
	public ArrayList<Vehiculo> leerTodos() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo leer(String matricula) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Vehiculo vehiculo, String matricula) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Vehiculo vehiculo) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTodo() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
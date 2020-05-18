package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.ExtrasVehiTurismos;
import Dominio.Vehiculo;
import Dominio.VehiculoTurismos;



public class VehiculoTurismoDao extends VehiculoDao{

	@Override
	public boolean insertar(Vehiculo vehiculo) throws ClassNotFoundException {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Turismos values ('"+vehiculo.getMatricula()+"','"+ vehiculo.getMarca()+"','"+vehiculo.getModelo()+"',"+vehiculo.getColor()
		+vehiculo.getPrecio();
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
		Connection co = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ORDER BY DNI";

		ArrayList<Vehiculo> listaTurismos = new ArrayList<Vehiculo>();
	
		
		try {
			co = Conexion.conectar();
			stm = co.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
					
				listaTurismos.add(new VehiculoTurismos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6);
			}
			stm.close();
			rs.close();
			co.close();
			

			for (int i = 0; i < listaTurismos.size(); i++) {
				co = Conexion.conectar();
				stm = co.createStatement();
				sql = "SELECT * FROM Turismos WHERE matricula='" + listaTurismos.get(i).getMatricula() + "'";
				rs = stm.executeQuery(sql);
				rs.next();
				listaTurismos.get(i).setMarca(rs.getString(2));
				listaTurismos.get(i).setModelo(rs.getString(3));
				listaTurismos.get(i).setColor(rs.getString(4));
				listaTurismos.get(i).setPrecio(rs.getInt(5));

				stm.close();
				rs.close();
				co.close();
			}
		} catch (SQLException e) {
			System.out.println("Error: Clase AlumnoDaoImple, método obtener");
			e.printStackTrace();
		}

		return listaTurismos;
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
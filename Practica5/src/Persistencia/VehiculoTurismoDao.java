package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.ExtrasVehiTurismos;
import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;
import Dominio.VehiculoTurismos;



public class VehiculoTurismoDao extends VehiculoDao{

	@Override
	public boolean insertar(Vehiculo vehiculo) throws ClassNotFoundException {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Turismos values ('"+VehiculoCamiones.getMatricula()+"','"+ VehiculoCamiones.getMarca()+"','"+VehiculoCamiones.getModelo()+"',"+vehiculo.getColor()
		+VehiculoCamiones.getPrecio();
	

		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			
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
					
				listaTurismos.add(new VehiculoTurismos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6), null));
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
		Connection co = null;
		Statement stm = null;
		ResultSet rs = null;

		Vehiculo leer = null;
		String sql = "SELECT * FROM Turismos WHERE matricula='" + matricula + "'";
		try {
			co = Conexion.conectar();
			stm = co.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				leer = new VehiculoTurismos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6), null);
			}
			stm.close();
			rs.close();
			co.close();
			if(leer!=null) {
				co = Conexion.conectar();
				stm = co.createStatement();
				sql = "SELECT * FROM turismos WHERE matricula='" + leer.getMatricula() + "'";
				rs = stm.executeQuery(sql);
				rs.next();
				leer.setMarca(rs.getString(2));
				leer.setModelo(rs.getString(3));
				leer.setColor(rs.getString(4));
				leer.setPrecio(rs.getDouble(5));
				}

		} catch (SQLException e) {
			System.out.println("Error:  método eliminar");
			e.printStackTrace();
		}
		return leer;
	}

	@Override
	public boolean actualizar(Vehiculo vehiculo, String matricula) throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
		if(VehiculoTurismos.getMatricula().equals(matricula)) {			
		String sql="UPDATE Turismos SET matricula='"+ VehiculoTurismos.getMatricula()+"', marca='"+VehiculoTurismos.getMarca()+"', modelo='"+VehiculoCamiones.getModelo()+"', precio="+VehiculoTurismos.getPrecio()+" WHERE matricula='"+VehiculoTurismos.getMatricula()+"'";
		
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			
			actualizar=true;
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}		
		}else {
		String sql="INSERT INTO turismos values ('"+VehiculoTurismos.getMatricula()+"','"+VehiculoTurismos.getMarca()+"','"+VehiculoTurismos.getModelo()+"',"+VehiculoTurismos.getPrecio()+")";
		
		String sql2="DELETE FROM turismos WHERE matricula='"+matricula+"'";
		
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			stm.execute(sql2);
			

			actualizar=true;
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}	
		}
			
		
		return actualizar;
	}

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
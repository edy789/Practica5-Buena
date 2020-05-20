package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dominio.ExtrasVehiTurismos;
import Dominio.VehiculoCamiones;


public class ExtrasVehiTurismosDao {
	public ExtrasVehiTurismosDao() {
			
		}
	public boolean insertar(ExtrasVehiTurismos extrasVehiTurismos) throws ClassNotFoundException {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Camines values ('"+VehiculoCamiones.getMatricula()+"','"+VehiculoCamiones.getMarca()+"','"+VehiculoCamiones.getModelo()+"',"+VehiculoCamiones.getColor() +")";
		String sql2="INSERT INTO Camiones values ('"+VehiculoCamiones.getMatricula()+"',"+((VehiculoCamiones)VehiculoCamiones).getCapacarga()+")";
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase BecaDaoImple, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	
	public ArrayList<ExtrasVehiTurismos> leerTodos() throws ClassNotFoundException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Becas6 ORDER BY id";
		
		ArrayList<ExtrasVehiTurismos> listaExtras= new ArrayList<ExtrasVehiTurismos>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				listaExtras.add(new ExtrasVehiTurismos(rs.getInt(1),rs.getString(2)));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase BecaDaoImple, método leerTodos");
			e.printStackTrace();
		}
		
		return listaExtras;
	}
 

	
	public ExtrasVehiTurismos leer(int identificador) throws ClassNotFoundException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		ExtrasVehiTurismos leerExtrasVehiTurismos = null;
		String sql="SELECT * FROM Extra WHERE identificador="+identificador+"";
		try {
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				leerExtrasVehiTurismos = new ExtrasVehiTurismos(rs.getInt(1),rs.getString(2));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error:  método leer");
			e.printStackTrace();
		}		
		return leerExtrasVehiTurismos;
	}
	
	
	public boolean actualizar(ExtrasVehiTurismos extrasVehiTurismos, int identificador) throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
		
		String sql="UPDATE Extra SET identificador="+extrasVehiTurismos.getIdentificador()+", descripcion="+extrasVehiTurismos.getDescripcion()+"' WHERE identificador="+identificador+"";
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}
			
		return actualizar;
	}
 
	
	public boolean eliminar(ExtrasVehiTurismos extrasVehiTurismos) throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		boolean actualizar=false;
		boolean eliminar=false;
		String sql="DELETE FROM Extra WHERE identificador='"+extrasVehiTurismos.getIdentificador()+"'";
		
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}	
		sql="DELETE FROM Extra WHERE identificador="+extrasVehiTurismos.getIdentificador()+"";
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error:  método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}

	public boolean eliminarTodo() throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
		String sql="DELETE FROM Extra";
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			stm.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error: método eliminarTodo");
			e.printStackTrace();
		}	
		return eliminar;		

	}

	
}

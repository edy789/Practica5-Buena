package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dominio.ExtrasVehiTurismos;


public class ExtrasVehiTurismosDao {
	public ExtrasVehiTurismosDao() {
			
		}
	public boolean insertar(ExtrasVehiTurismos extrasVehiTurismos) throws ClassNotFoundException {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Extra values ("+beca.getId()+", "+beca.getCuota()+",'"+beca.getDescripcion()+"')";
		
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
 
	
	public ArrayList<Beca> leerTodos() throws ClassNotFoundException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Becas6 ORDER BY id";
		
		ArrayList<Beca> listaBeca= new ArrayList<Beca>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				listaBeca.add(new Beca(rs.getInt(1),rs.getDouble(2),rs.getString(3)));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase BecaDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaBeca;
	}
 

	
	public Beca leer(int id) throws ClassNotFoundException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		Beca leerBeca = null;
		String sql="SELECT * FROM Becas6 WHERE id="+id+"";
		try {
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				leerBeca = new Beca(rs.getInt(1),rs.getDouble(2),rs.getString(3));
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error:  método eliminar");
			e.printStackTrace();
		}		
		return leerBeca;
	}
	public boolean actualizar(Beca beca, int id) throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
		
		String sql="UPDATE Becas6 SET id="+beca.getId()+", cuota="+beca.getCuota()+", descripcion='"+beca.getDescripcion()+"' WHERE id="+id+"";
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
 
	
	public boolean eliminar(Beca beca) throws ClassNotFoundException {
		Connection connect= null;
		Statement stm= null;
		boolean actualizar=false;
		boolean eliminar=false;
		String sql="UPDATE Alumnos6 SET beca=1 WHERE beca="+beca.getId()+"";
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
		sql="DELETE FROM Becas6 WHERE id="+beca.getId()+"";
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
		boolean actualizar=false;
		String sql="UPDATE Alumnos6 SET beca=1";
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
		sql="DELETE FROM Becas6 WHERE id<>1";
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

}

	
}

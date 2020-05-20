package Presentaci�n;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Dominio.Alumno;
import Dominio.Empleado;
import Dominio.Persona;
import Dominio.Profesor;
import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Empleado emp = null;
		int opcion=0;
		
		// Cargar los datos
		String usu="";
		String clave="";
		
		System.out.println("Bienvenido a su administrador de vehiculos\n");
		
		buscarPersona();
		
		System.out.println("Inserte su loggin");
		usu = sc.next();
		System.out.println("Inserte su contrase�a");
		clave = sc.next();
		
		
		
		
		// Men� principal
		do {
			try {
				System.out.println("\nMen�");
				System.out.println("1.  Mostrar todos los veh�culos");
				System.out.println("2.  Buscar un veh�culo");
				System.out.println("3.  A�adir un veh�culo");
				System.out.println("4.  Modificar un veh�culo");
				System.out.println("5.  Eliminar un veh�culo");
				System.out.println("6.  Eliminar todos los veh�culos");
				System.out.println("7.  Mostrar todos los extras");
				System.out.println("8.  Buscar un extra");
				System.out.println("9.  Insertar un extra");
				System.out.println("10. Modificar un extra");
				System.out.println("11. Eliminar un extra");
				System.out.println("12. Eliminar todos los extras");
				System.out.println("13. Log out");
				opcion = sc.nextInt();

				System.out.print("\n");
				
				switch (opcion) {
				case 1:
					mostrarVehiculos();
					break;
				case 2:
					buscarVehiculo();
					break;
				case 3:
					a�adirvehiculo();
					break;
				case 4:
					modificarVehiculo();
					break;
				case 5:
					eliminarVehiculo();
					break;
				case 6:
					eliminarTodasLosVehiculos();
					break;
				case 7:
					mostrarExtras();
					break;
				case 8:
					buscarExtra();
					break;
				case 9:
					a�adirExtra();
					break;
				case 10:
					modificarExtra();
					break;
				case 11:
					eliminarUnExtras();
					break;
				case 12:
					eliminarTodosLosExtras();
					break;
				case 13:
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("Introduce un n�mero de 1 a 13");
				}

			} catch (InputMismatchException e) {
				System.err.println("Introduce un n�mero");
				sc.nextLine();
			}
		} while (opcion!=13);
	}

	private static void mostrarVehiculos() {
		// TODO Auto-generated method stub
		
		
		
	}

	private static void buscarVehiculo() {
		// TODO Auto-generated method stub
		
	}

	private static void a�adirvehiculo() {
		// TODO Auto-generated method stub
		
	}

	private static void modificarVehiculo() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarVehiculo() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarTodasLosVehiculos() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarExtras() {
		// TODO Auto-generated method stub
		
	}

	private static void buscarExtra() {
		// TODO Auto-generated method stub
		
	}

	private static void a�adirExtra() {
		// TODO Auto-generated method stub
		
	}

	private static void modificarExtra() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarUnExtras() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarTodosLosExtras() {
		// TODO Auto-generated method stub
		
	}
	
	public static void buscarPersona() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el Loggin");
		String DNI = sc.next();
		System.out.println("Indica el Loggin");
		String DNI = sc.next();
		Persona leerAlumno = new Alumno();
		leerAlumno = leerAlumno.leerPersona(DNI);
		Persona leerProfesor = new Profesor();
		leerProfesor = leerProfesor.leerPersona(DNI);
		if (leerAlumno != null) {
			System.out.println(leerAlumno.toString());
		} else if (leerProfesor != null) {
			System.out.println(leerProfesor.toString());
		} else {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}

	}
	

	}



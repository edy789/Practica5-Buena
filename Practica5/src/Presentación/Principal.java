package Presentaci�n;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Dominio.Empleado;
import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;

class excepcionUsuario extends Exception {
}

class excepcionPassword extends Exception {
}

class excepcionFueraRango extends Exception {
}

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		
		// Cargar los datos e inicio de programa
		
		System.out.println("Bienvenido a su administrador de vehiculos\n");
		
		LogginEmpleado();
		
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
	
	public static void LogginEmpleado() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el Loggin");
		String loggin = sc.next();
		System.out.println("Indica su contrase�a");
		String password = sc.next();
		Empleado leerEmpleado = new Empleado();
		leerEmpleado = leerEmpleado.leerEmpleado(loggin,password);
		
		if (leerEmpleado != null) {
			System.out.println(leerEmpleado.toString());
		} else {
			System.out.printf("No existe la Empleado con el loggin %s o con password %s \n", loggin , password);
		}
		

	}

	}


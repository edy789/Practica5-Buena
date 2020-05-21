package Presentación;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Dominio.ExtrasVehiTurismos;
import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;
import Dominio.VehiculoTurismos;

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
		
		
		
		
		
		
		// Menú principal
		do {
			try {
				System.out.println("\nMenú");
				System.out.println("1.  Mostrar todos los vehículos");
				System.out.println("2.  Buscar un vehículo");
				System.out.println("3.  Añadir un vehículo");
				System.out.println("4.  Modificar un vehículo");
				System.out.println("5.  Eliminar un vehículo");
				System.out.println("6.  Eliminar todos los vehículos");
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
					añadirvehiculo();
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
					añadirExtra();
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
					System.out.println("Introduce un número de 1 a 13");
				}

			} catch (InputMismatchException e) {
				System.err.println("Introduce un número");
				sc.nextLine();
			}
		} while (opcion!=13);
	}

	private static void mostrarVehiculos() {
		// TODO Auto-generated method stub
	}

	private static void buscarVehiculo() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la matricula");
		String Matricula = sc.next();
		Vehiculo leerCamiones = new VehiculoCamiones();
		leerCamiones = leerCamiones.leerVehiculo(Matricula);
		Vehiculo leerTurismos = new VehiculoTurismos();
		leerTurismos = leerTurismos.leerVehiculo(Matricula);
		if (leerCamiones != null) {
			System.out.println(leerCamiones.toString());
		} else if (leerTurismos != null) {
			System.out.println(leerTurismos.toString());
		} else {
			System.out.printf("No existe el vehiculo con la matricula %s\n", Matricula);
		}
		
	}

	private static void añadirvehiculo() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		boolean seguir = false;
		String Matricula = "";
		ExtrasVehiTurismos newextra = new ExtrasVehiTurismos();
		do {
			seguir = false;
			System.out.println("Introduzca matricula");
			Matricula = sc.next();
			Vehiculo existeTurismo = new VehiculoTurismos();
			existeTurismo = existeTurismo.leerVehiculo(Matricula);
			Vehiculo existeCamion = new VehiculoCamiones();
			existeCamion = existeCamion.leerVehiculo(Matricula);
			if (existeTurismo != null) {

				if (existeTurismo.getMatricula().equals(Matricula)) {
					System.out.println("Matricula repetida");
					seguir = true;
				}
			}
			
			if (existeCamion != null) {

				if (existeCamion.getMatricula().equals(Matricula)) {
					System.out.println("Matricula repetida");
					seguir = true;
				}
			}
		} while (seguir);
		System.out.println("Introduzca marca");
		sc.nextLine();
		String marca = sc.nextLine();
		System.out.println("Introduzca modelo");
		String modelo = sc.nextLine();
		System.out.println("Introduzca color");
		String color = sc.nextLine();
		int precio = 0;
		do {
			seguir = false;
			try {
				System.out.println("Introduzca el precio");
				precio = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Introduzce solo números");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);
		int opcion = 0;
		do {
			try {
				System.out.println("¿Es turismo o camion?\n1. Turismo\n2. Camion");
				opcion = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Introduzce solo números");
				sc.nextLine();
			}
		} while (opcion != 1 && opcion != 2);
		int extra = 0;
		if (opcion == 1) {

			do {
				seguir = false;
				try {
					mostrarExtras();
					System.out.println("Introduzca extra");
					extra = sc.nextInt();
					newextra = new ExtrasVehiTurismos();
					newextra = newextra.leerExtrasVehiTurismos(extra);
					if (newextra == null) {
						seguir = true;
						System.out.println("El extra no existe");

					}
				} catch (InputMismatchException e) {
					System.err.println("Introduzce solo números");
					seguir = true;
					sc.nextLine();
				}
			} while (seguir);

			Vehiculo newVehiculo = new VehiculoTurismos(Matricula, marca, modelo, color, precio, extra, newextra);
			newVehiculo.insertar();

		}
		double capacarga = 0;
		if (opcion == 2) {

			do {
				seguir = false;
				try {
					System.out.println("Introduzca el capacidad de carga");
					capacarga = sc.nextDouble();
				} catch (InputMismatchException e) {
					System.err.println("Introduzce solo números");
					seguir = true;
					sc.nextLine();
				}
			} while (seguir);
			Vehiculo newVehiculo = new VehiculoCamiones(Matricula, marca, modelo, color, precio, capacarga);
			newVehiculo.insertar();
		}
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

	private static void añadirExtra() {
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
		String loggin = sc.next();
		System.out.println("Indica su contraseña");
		String clave = sc.next();
		Empleado leerEmpleado = new Empleado();
		leerAlumno = leerAlumno.leerPersona(DNI);
		
		if (leerAlumno != null) {
			System.out.println(leerAlumno.toString());
		} else if (leerProfesor != null) {
			System.out.println(leerProfesor.toString());
		} else {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}

	}

	}



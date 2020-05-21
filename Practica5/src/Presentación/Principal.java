package Presentación;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
<<<<<<< HEAD

import Dominio.ExtrasVehiTurismos;
import Dominio.Beca;
import Dominio.Empleado;
>>>>>>> branch 'master' of https://github.com/edy789/Practica5-Buena.git
import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;
import Dominio.VehiculoTurismos;

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
		boolean sinExtras = true;
		ExtrasVehiTurismos buscarExtras = new ExtrasVehiTurismos();
		ArrayList<ExtrasVehiTurismos> extras = buscarExtras.leerTodos();
		for (int i = 0; i < extras.size(); i++) {
			System.out.println(extras.get(i).toString());
			sinExtras = false;
		}

		if (sinExtras) {
			System.out.println("No existen extras");

		}
	}

	private static void buscarExtra() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el Id de extra");
		int identificador = sc.nextInt();
		ExtrasVehiTurismos leerExtra = new ExtrasVehiTurismos();
		leerExtra = leerExtra.leerExtrasVehiTurismos(identificador);
		
		if (leerExtra != null) {
			System.out.println(leerExtra.toString());
		} else {
			System.out.printf("No existe el extra con la identificador %s\n", identificador);
		}
	}

	private static void añadirExtra() {
		Scanner sc = new Scanner(System.in);

		boolean seguir = false;
		int ident = 0;
		do {
			seguir = false;
			System.out.println("Introduzca el identificador de extra");
			ident = sc.nextInt();
			ExtrasVehiTurismos existeExtras = new ExtrasVehiTurismos();
			existeExtras = existeExtras.leerExtrasVehiTurismos(ident);

			if (existeExtras != null) {

				if (existeExtras.getIdentificador() == ident) {
					System.out.println("identificador repetido ingresa otro");
					seguir = true;
				}
			}

		} while (seguir);
		
		System.out.println("Introduzca la descripcion");
		sc.nextLine();
		String descExtra = sc.nextLine();

		ExtrasVehiTurismos newExtra = new ExtrasVehiTurismos(ident, descExtra);
		newExtra.insertar();
	}

	private static void modificarExtra() {
		Scanner sc = new Scanner(System.in);
		ExtrasVehiTurismos modExtra = new ExtrasVehiTurismos();

		System.out.println("Indica el identificador");
		int ident = sc.nextInt();
		modExtra = modExtra.leerExtrasVehiTurismos(ident);

		if (modExtra != null) {
			System.out.println("¿Qué deseas modificar?");
			System.out.println("1. identificador");
			System.out.println("2. Descripción");
			int opcion = sc.nextInt();
			switch (opcion) {
			
			case 1:
				boolean repetido = false;
				do {
					repetido = false;
					System.out.println("Introduce el nuevo identificador");
					int Id = sc.nextInt();
					ExtrasVehiTurismos existeExtra = new ExtrasVehiTurismos();
					existeExtra = existeExtra.leerExtrasVehiTurismos(Id);

					if (existeExtra != null) {
						if (existeExtra.getIdentificador() == Id) {
							System.out.println("identificador repetido");
							repetido = true;
						}
					} else {
						modExtra.setIdentificador(Id);
					}
				} while (repetido);
				break;
				
				
			case 2:
				System.out.println("Introduce la descripcion");
				sc.nextLine();
				String descripcion = sc.nextLine();
				modExtra.setDescripcion(descripcion);
				break;

			}
			modExtra.actualizar(ident);
		} else {
			System.out.printf("No existe el Extra con el identificador %d\n", ident);

		}
	}

	private static void eliminarUnExtras() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Indica el identificador");
		int ident = sc.nextInt();
		ExtrasVehiTurismos delExtra = new ExtrasVehiTurismos();
		delExtra = delExtra.leerExtrasVehiTurismos(ident);

		if (delExtra != null) {
			delExtra.eliminar();

		} else {
			System.out.printf("No existe el extra con el identificador %d\n", ident);
		}
	}

	private static void eliminarTodosLosExtras() {
		ExtrasVehiTurismos eliminarTodosExtras = new ExtrasVehiTurismos();
		eliminarTodosExtras.eliminarTodo();

	}

	
	public static void LogginEmpleado() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el Loggin");
		String loggin = sc.next();
		System.out.println("Indica su contraseña");
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


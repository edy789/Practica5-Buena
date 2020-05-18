package Presentación;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Dominio.Vehiculo;
import Dominio.VehiculoCamiones;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int opcion=0;
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
					System.out.println("Introduce un número de 1 a 14");
				}

			} catch (InputMismatchException e) {
				System.err.println("Introduce un número");
				sc.nextLine();
			}
		} while (opcion!=14);
	}

	private static void mostrarVehiculos() {
		// TODO Auto-generated method stub
		
	}

	private static void buscarVehiculo() {
		// TODO Auto-generated method stub
		
	}

	private static void añadirvehiculo() {
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
	
	//C3

	}



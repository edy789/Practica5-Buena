package Presentaci�n;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Dominio.*;

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

	private static void mostrarVehiculos() throws ClassNotFoundException {
		boolean sinVehiculos = true;
		Vehiculo buscarVehiculo = new VehiculoTurismos();
		ArrayList<Vehiculo> Vehiculos = buscarVehiculo.leerTodos();
		for (int i = 0; i < Vehiculos.size(); i++) {
			System.out.println(Vehiculos.get(i).toString());
			sinVehiculos = false;
		}
		buscarVehiculo = new VehiculoCamiones();
		Vehiculos = buscarVehiculo.leerTodos();
		for (int i = 0; i < Vehiculos.size(); i++) {
			System.out.println(Vehiculos.get(i).toString());
			sinVehiculos = false;
		}
		if (sinVehiculos) {
			System.out.println("No existen vehiculos");

		}
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

	private static void a�adirvehiculo() throws ClassNotFoundException {
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
				System.err.println("Introduzce solo n�meros");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);
		int opcion = 0;
		do {
			try {
				System.out.println("�Es turismo o camion?\n1. Turismo\n2. Camion");
				opcion = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Introduzce solo n�meros");
				sc.nextLine();
			}
		} while (opcion != 1 && opcion != 2);
		int extra = 0;
		int numpuertas = 0;
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
					System.err.println("Introduzce solo n�meros");
					seguir = true;
					sc.nextLine();
				}
			} while (seguir);

			Vehiculo newVehiculo = new VehiculoTurismos(Matricula, marca, modelo, color, precio, numpuertas, newextra);
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
					System.err.println("Introduzce solo n�meros");
					seguir = true;
					sc.nextLine();
				}
			} while (seguir);
			Vehiculo newVehiculo = new VehiculoCamiones(Matricula, marca, modelo, color, precio, capacarga);
			newVehiculo.insertar();
		}
	}

	private static void modificarVehiculo() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Vehiculo modTurismo = new VehiculoTurismos();
		Vehiculo modCamion = new VehiculoCamiones();

		System.out.println("Indica la matricula"); 
		String Matricula = sc.next();
		modTurismo = modTurismo.leerVehiculo(Matricula);
		modCamion = modCamion.leerVehiculo(Matricula);

		if (modTurismo != null || modCamion != null) {
			System.out.println("�Qu� deseas modificar?");
			System.out.println("1. Matricula");
			System.out.println("2. Marca");
			System.out.println("3. Modelo");
			System.out.println("4. Color");
			System.out.println("5. Precio");
			if (modTurismo != null) {
				System.out.println("6. Extras");
				System.out.println("7. Numero de puertas");
			}
			if (modCamion != null) {
				System.out.println("5. Capacidad de carga");
			}
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				boolean repetido = false;
				do {
					repetido = false;
					System.out.println("Introduce la nueva matricula");
					String matricula = sc.next();
					Vehiculo existeTurismo = new VehiculoTurismos();
					existeTurismo = existeTurismo.leerVehiculo(matricula);
					Vehiculo existeCamion = new VehiculoCamiones();
					existeCamion = existeCamion.leerVehiculo(matricula);
					if (existeTurismo != null) {
						if (existeTurismo.getMatricula().equals(matricula)) {
							System.out.println("Matricula repetido");
							repetido = true;
						}
					} else if (existeCamion != null) {
						if (existeCamion.getMatricula().equals(matricula)) {
							System.out.println("Matricula repetido");
							repetido = true;
						}
					} else {

						if (modTurismo != null) {
							modTurismo.setMatricula(matricula);
						}
						if (modCamion != null) {
							modCamion.setMatricula(matricula);
						}
					}
				} while (repetido);
				break;
			case 2:
				System.out.println("Introduce la nueva marca");
				sc.nextLine();
				String marca = sc.nextLine();
				if (modTurismo != null) {
					modTurismo.setMatricula(marca);
				}
				if (modCamion != null) {
					modCamion.setMatricula(marca);
				}
				break;
			case 3:
				System.out.println("Introduce el nuevo modelo");
				sc.nextLine();
				String modelo = sc.nextLine();
				if (modTurismo != null) {
					modTurismo.setModelo(modelo);
				}
				if (modCamion != null) {
					modCamion.setModelo(modelo);
				}
				break;
			case 4:
				System.out.println("Introduce el nuevo color");
				sc.nextLine();
				String color = sc.nextLine();
				if (modTurismo != null) {
					modTurismo.setColor(color);
				}
				if (modCamion != null) {
					modCamion.setColor(color);
				}
				break;
			case 5:
				boolean seguir = false;
				do {
					seguir = false;
					try {
						System.out.println("Introduce el nuevo precio");
						int precio = sc.nextInt();
						if (modTurismo != null) {
							modTurismo.setPrecio(precio);
						}
						if (modCamion != null) {
							modCamion.setPrecio(precio);
						}

					} catch (InputMismatchException e) {
						System.err.println("Introduzce solo n�meros");
						sc.nextLine();
						seguir = true;
					}
				} while (seguir);
				break;
			case 6:
				if (modTurismo != null) {
					seguir = false;
					do {
						seguir = false;
						try {
							mostrarExtras();
							System.out.println("Introduce el nuevo extra");
							int extra = sc.nextInt();
							ExtrasVehiTurismos modExtra = new ExtrasVehiTurismos();
							modExtra = modExtra.leerExtrasVehiTurismos(extra);
							if (modExtra == null) {
								seguir = true;
								System.out.println("El extra no existe");

							} else {
								((VehiculoTurismos) modTurismo).setExtras(modExtra);
							}
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo n�meros");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
				}
				if (modCamion != null) {
					seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce la nueva capacidad de carga");
							double capacarga = sc.nextDouble();
							((VehiculoCamiones) modCamion).setCapacarga(capacarga);

						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo n�meros");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
				}
				break;
			case 7:
				if (modCamion != null) {
					seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce el nuevo numero de puertas");
							int numpuertas = sc.nextInt();
							((VehiculoTurismos) modTurismo).setNumpuertas(numpuertas);

						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo n�meros");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
				}
				break;

			}
			if (modTurismo != null) {
				modTurismo.actualizar(Matricula);

			} else if (modCamion != null) {
				modCamion.actualizar(Matricula);

			}

		} else {
			System.out.printf("No existe el vehiculo con matricula %s\n", Matricula);

		}

	}

	private static void eliminarVehiculo() throws ClassNotFoundException  {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la matricula");
		String matricula = sc.next();
		Vehiculo delTurismo = new VehiculoTurismos();
		delTurismo = delTurismo.leerVehiculo(matricula);
		Vehiculo delCamion = new VehiculoCamiones();
		delCamion = delCamion.leerVehiculo(matricula);
		if (delTurismo != null) {
			delTurismo.eliminar();
		} else if (delCamion != null) {
			delCamion.eliminar();
		} else {
			System.out.printf("No existe el vehiculo con matricula %s\n", matricula);
		}

	}
		
	private static void eliminarTodasLosVehiculos() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Vehiculo eliminarCamiones = new VehiculoCamiones();
		Vehiculo eliminarTurismos= new VehiculoTurismos();
		eliminarCamiones.eliminarTodo();
		eliminarTurismos.eliminarTodo();


		
	}

	private static void mostrarExtras() throws ClassNotFoundException {
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

	private static void a�adirExtra() throws ClassNotFoundException {
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

	private static void modificarExtra() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		ExtrasVehiTurismos modExtra = new ExtrasVehiTurismos();

		System.out.println("Indica el identificador");
		int ident = sc.nextInt();
		modExtra = modExtra.leerExtrasVehiTurismos(ident);

		if (modExtra != null) {
			System.out.println("�Qu� deseas modificar?");
			System.out.println("1. identificador");
			System.out.println("2. Descripci�n");
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

	private static void eliminarUnExtras() throws ClassNotFoundException {
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

	private static void eliminarTodosLosExtras() throws ClassNotFoundException {
		ExtrasVehiTurismos eliminarTodosExtras = new ExtrasVehiTurismos();
		eliminarTodosExtras.eliminarTodo();

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


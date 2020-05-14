package Presentación;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		int opcion=0;
		// Menú principal
		do {
			try {
				System.out.println("\nMenú");
				System.out.println("1. Mostrar todos los vehículos");
				System.out.println("2. Buscar un vehículo");
				System.out.println("3. Insertar un vehículo");
				System.out.println("4. Modificar un vehículo");
				System.out.println("5. Eliminar un vehículo");
				System.out.println("6. Eliminar todos los vehículos");
				System.out.println("7. Mostrar todos los extras");
				System.out.println("8. Buscar un extra");
				System.out.println("9. Insertar un extra");
				System.out.println("10. Modificar un extra");
				System.out.println("11. Eliminar un extra");
				System.out.println("12. Eliminar todos los extras");
				System.out.println("13. Mostrar vehículo por palabra a buscar");
				System.out.println("14. Log out");
				opcion = sc.nextInt();

				System.out.print("\n");
				
				switch (opcion) {
				case 1:
					mostrarTodos();
					break;
				case 2:
					buscarPersona();
					break;
				case 3:
					añadirPersona();
					break;
				case 4:
					modificarPersona();
					break;
				case 5:
					eliminarPersona();
					break;
				case 6:
					eliminarTodasLasPersonas();
					break;
				case 7:
					eliminarPersonasMenores25();
					break;
				case 8:
					eliminarJubilados();
					break;
				case 9:
					mostrarPersonasEntre20Y40();
					break;
				case 10:
					mostrarPersonasLetraApellido();
					break;
				case 11:
					modificarPersonasAumentar10Años();
					break;
				case 12:
					mostrarPersonasIntroducidaTeclado();
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
	
	//C3
	public static void mostrarPersonasIntroducidaTeclado() throws ClassNotFoundException {	//se crea el metodo para procesar los datos a introducir
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la palabra a buscar");
		String letras = sc.next();
		Persona leerPersona = new Persona();		//se usa la clase personas para acceder a sus atributos
		ArrayList<Persona> personas=leerPersona.leerPersonasIntroducidaTeclado(letras);	//Se crea el array de persona para listar las personas y se accede a sus metodos
		for (int i = 0; i < personas.size(); i++) {				//Se genera un for para recorrer e imprimir la lista de personas
			System.out.println(personas.get(i).toString());
		}
		if(personas.size()==0) {	//Se genera esta condicion para saber si los datos solicitados no coinciden con ningun atributo de la DDBB
			System.out.println("No existen apellido en la tabla personas que contenga las letras "+letras);

		}	
		
	}
	//M3
	public static void modificarPersonasAumentar10Años() throws IOException, ClassNotFoundException {	//se crea el metodo para procesar la instruccion solicitada
		int edad =0;
		Persona modpersona = new Persona();				//se usa la clase personas para acceder a sus atributos
		//modEdad=modEdad.modificarPersonasAumentar10Años();
		
		ArrayList<Persona> personas=modpersona.leerTodos();	//Se crea el array de persona para listar las personas y se accede a sus metodos
			
			for (int i = 0; i < personas.size(); i++) {		//Se genera un for para recorrer lista de personas
				edad = personas.get(i).getEdad() + 10;		//Instruccion que hace que la edad se le sume 10 años a la edad
				personas.get(i).setEdad(edad);				//Se genera que el todo el array de personas se modifique por el valor que se sumado anteriormente
				
				personas.get(i).modificarPersonasAumentar10Años();			//Se llama a el metodo de personas para asi que se modifique en la DDBB			
				System.out.println("Si se ejecura el leerPersonasAumentar10Años");
				System.out.println(personas.get(i).toString());
			}			
	}		
	
	public static void mostrarPersonasLetraApellido() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la letra incial del apellido");
		String letra = sc.next();
		Persona leerPersona = new Persona();
		ArrayList<Persona> personas=leerPersona.leerPersonasLetraintroducidaApellido(letra);
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).toString());
		}
		if(personas.size()==0) {
			System.out.println("No existen personas en el apellido que empiecen por la letra "+letra);

		}	
		
	}

	public static void mostrarPersonasEntre20Y40() throws ClassNotFoundException {
		Persona buscarPersona = new Persona();
		ArrayList<Persona> personas = buscarPersona.leerPersonasEntre20Y40();
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).toString());
		}
		if(personas.size()==0) {
			System.out.println("No existen personas");

		}		
	}

	public static void eliminarJubilados() throws ClassNotFoundException {
		Persona eliminarJubilados = new Persona();	
		eliminarJubilados.eliminarJubilados();				
	}

	public static void eliminarPersonasMenores25() throws ClassNotFoundException {
		Persona eliminarPersonasMenores25 = new Persona();	
		eliminarPersonasMenores25.eliminarMenores25();		
	}

	public static void eliminarTodasLasPersonas() throws ClassNotFoundException {
		Persona eliminarTodasPersonas = new Persona();	
		eliminarTodasPersonas.eliminarTodo();
	}

	public static void modificarPersona() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Persona modPersona = new Persona();
		System.out.println("Indica el DNI");
		String DNI = sc.next();
		modPersona=modPersona.leerPersona(DNI);
			if (modPersona!=null) {
				System.out.println("¿Qué deseas modificar?");
				System.out.println("1. DNI");
				System.out.println("2. Nombre");
				System.out.println("3. Apellidos");
				System.out.println("4. Edad");
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					boolean repetido=false;
					do {
						repetido=false;
					System.out.println("Introduce el nuevo DNI");
					String dni = sc.next();
					Persona existePersona=new Persona();
					existePersona=existePersona.leerPersona(dni);
					if(existePersona!=null) {
						if(existePersona.getDNI().equals(dni)) {
							System.out.println("DNI repetido");
							repetido=true;
						}else {
							modPersona.setDNI(dni);
						}
					}else {
						modPersona.setDNI(dni);
					}
					}while(repetido);
					break;
				case 2:
					System.out.println("Introduce el nuevo nombre");
					String nombre = sc.next();
					modPersona.setNombre(nombre);
					break;
				case 3:
					System.out.println("Introduce el nuevo apellido");
					sc.nextLine();
					String apellidos = sc.nextLine();
					modPersona.setApellidos(apellidos);
					break;
				case 4:
					boolean seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce el nueva edad");
							int edad = sc.nextInt();
							modPersona.setEdad(edad);
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
				
				break;
				default:
					System.out.printf("No existe el caso %d\n", opcion);

			}
				modPersona.actualizar(DNI);

		}else {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}

	}

	public static void eliminarPersona() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el DNI");
		String DNI = sc.next();
		Persona delPersona = new Persona();
		delPersona=delPersona.leerPersona(DNI);
		if(delPersona!=null) {
				delPersona.eliminar();
		}else {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}
	}

	public static void añadirPersona() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		boolean seguir = false;
		String DNI = "";
		do {
			seguir = false;
			System.out.println("Introduzca el DNI");
			DNI = sc.next();
			Persona existePersona = new Persona ();
			existePersona=existePersona.leerPersona(DNI);
			if (existePersona!=null) {
				
				if (existePersona.getDNI().equals(DNI)) {
					System.out.println("DNI repetido");
					seguir = true;
				}
			}

		} while (seguir);
		System.out.println("Introduzca el nombre");
		String nombre = sc.next();
		System.out.println("Introduzca el apellido");
		sc.nextLine();
		String apellidos = sc.nextLine();
		int edad = 0;
		do {
			seguir = false;
			try {
				System.out.println("Introduzca la edad");
				edad = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Introduzce solo números");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);
		Persona newPersona = new Persona(DNI, nombre, apellidos, edad);
		newPersona.insertar();
	}

	public static void buscarPersona() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica el DNI");
		String DNI = sc.next();
		Persona leerPersona = new Persona();
		leerPersona=leerPersona.leerPersona(DNI);
		if(leerPersona!=null) {
			System.out.println(leerPersona.toString());
		}else {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}

	}

	public static void mostrarTodos() throws ClassNotFoundException {
		Persona buscarPersona = new Persona();
		ArrayList<Persona> personas = buscarPersona.leerTodos();
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).toString());
		}
		if(personas.size()==0) {
			System.out.println("No existen personas");

		}
	}

}

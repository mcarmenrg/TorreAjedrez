package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	private static Torre torre = null;
	private static void mostrarTorre(){
		if (torre == null){
			System.out.print("No se ha creado torre aún");
		}else {
			System.out.print("Torre es "+ torre );
		}

	}
	private static void mostrarMenu(){
		System.out.println("|| 1.Crear torre genérica(por defecto                       ||");
		System.out.println("|| 2.Crear torre a partir de un color                       ||");
		System.out.println("|| 3.Crear torre a partir de un color y una columna inicial ||");
		System.out.println("|| 4.Mover torre                                            ||");
		System.out.println("|| 0.Salir                                                  ||");
	}

	private static int elegirOpcion(){
		int opcion;
		do {
			System.out.println("¿Qué opción eliges?");
			opcion= Entrada.entero();
		}while (opcion< 0 || opcion>4 );
		return opcion;

	}
	private static Color elegirColor(){
		int opcion;
		System.out.println("|| 1.Negro  ||");
		System.out.println("|| 2.Blanco ||");
		do {
			System.out.println("¿Qué opción eliges?");
			opcion= Entrada.entero();
		}while (opcion<1 || opcion>2 );
		Color color ;
		if(opcion ==1 ){
			color=Color.BLANCO;
		}else {
			color=Color.NEGRO;
		}
		return color;



	}
	public static void main(String[] args) {
		System.out.println("kk");
	}

}

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
	private static char elegirColumnaInicial(){
		char columna = 0;
		int opcion;
		System.out.println("|| 1.a  ||");
		System.out.println("|| 2.h  ||");
		do {
			System.out.println("¿Qué opción eliges?");
			opcion= Entrada.entero();
		}while (opcion<1 || opcion>2 );
		if (opcion == 1){
			columna ='a';
		}else if (opcion == 2){
			columna ='h';
		}
		return columna;

	}
	private static void mostrarMenuDirecciones(){
		System.out.println("|| 1.ARRIBA            ||");
		System.out.println("|| 2.ABAJO             ||");
		System.out.println("|| 3.IZQUIERDA         ||");
		System.out.println("|| 4.DERECHA           ||");
		System.out.println("|| 5.ENROQUE CORTO     ||");
		System.out.println("|| 6.ENROQUE LARGO     ||");

	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}

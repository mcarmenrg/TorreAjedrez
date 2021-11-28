package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class MainApp {
	private static Torre torre = null;
	private static void mostrarTorre(){
		if (torre == null){
			System.out.println("No se ha creado torre aún");
		}else {
			System.out.println("Torre es "+ torre );
		}

	}
	private static void mostrarMenu(){
		System.out.println("|| 1.Crear torre genérica (por defecto)                     ||");
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
			color=Color.NEGRO;
		}else {
			color=Color.BLANCO;
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
	 private static Direccion elegirDireccion(){
		int opcion;
		Direccion direccion = null;
		 do {
			 System.out.println("¿Qué opción eliges?");
			 opcion= Entrada.entero();
		 }while (opcion<1 || opcion>6 );


		 switch (opcion){
			 case 1:
				 direccion=Direccion.ARRIBA;
				 break;
			 case 2:
				 direccion=Direccion.ABAJO;
				 break;
			 case 3:
				 direccion=Direccion.IZQUIERDA;
				 break;
			 case 4:
			 	direccion=Direccion.DERECHA;
			 	break;
			 case 5:
				 direccion=Direccion.ENROQUE_CORTO;
				 break;
			 case 6:
				 direccion=Direccion.ENROQUE_LARGO;
				 break;
			 default:
				 break;
		 }
		 return direccion;

	 }

	 private static void crearTorreDefecto(){
		torre=new Torre();
		System.out.println("Se ha creado torre de color negro en posición 8h");
	 }

	 private static void crearTorreColor(){
		Color color = elegirColor();
		torre = new Torre(color);
		System.out.println ("Se crea una torre a partir del color");

	 }
	 private static void crearTorreColorColumna(){
		char columna;
		 Color color = elegirColor();
		 columna =elegirColumnaInicial();
		 torre = new Torre(color,columna);
		 System.out.println ("Se crea una torre a partir del color y columna");
	 }
	private static void mover() throws OperationNotSupportedException {
		mostrarMenuDirecciones();
		Direccion direccion;
		direccion=elegirDireccion();
		int pasos;
		System.out.println ("¿Cuantos pasos vas a dar?");
		pasos=Entrada.entero();

		torre.mover(direccion,pasos);
		System.out.println("Se ha realizado el movimiento");

	}

	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch(opcion){
			case 1:
				crearTorreDefecto();
				break;
			case 2:
				crearTorreColor();
				break;
			case 3:
				crearTorreColorColumna();
				break;
			case 4:
				mover();
				break;
			default:
				break;
		}

	}


	public static void main(String[] args) throws OperationNotSupportedException {
		int opcion;
		do {
			mostrarMenu();
			opcion=elegirOpcion();
			ejecutarOpcion(opcion);
			mostrarTorre();

		}while(opcion != 0);

		System.out.println ("Hasta la próxima");

	}


}

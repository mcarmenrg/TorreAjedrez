package org.iesalandalus.programacion.torreajedrez;

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
		System.out.print("|| 1.Crear torre genérica(por defecto                       ||");
		System.out.print("|| 2.Crear torre a partir de un color                       ||");
		System.out.print("|| 3.Crear torre a partir de un color y una columna inicial ||");
		System.out.print("|| 4.Mover torre                                            ||");
		System.out.print("|| 0.Salir                                                  ||");
	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}

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
	public static void main(String[] args) {
		System.out.println("kk");
	}

}

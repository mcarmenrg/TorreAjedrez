package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public Posicion (int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }
    public Posicion(Posicion posicion){
        if (posicion != null){
            setFila(posicion.getFila());
            setColumna(posicion.getColumna());
        }else{
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.") ;
        }

    }

    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {

        if (fila>=1 && fila<=8){
            this.fila = fila;
        } else {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }

    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna>='a' && columna<='h'){
            this.columna = columna;
        }else {
            throw new IllegalArgumentException("ERROR: Columna no válida.");

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;

    }
}



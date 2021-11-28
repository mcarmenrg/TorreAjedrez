package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Torre
{
    private Color color;
    private Posicion posicion;

    public Torre (){
        color = Color.NEGRO;
        posicion = new Posicion (8, 'h');
    }

    public Torre (Color color){
        if(color == Color.BLANCO){
            posicion = new Posicion (1,'h');
        }else if (color == Color.NEGRO)  {
            posicion = new Posicion (8,'h');
        }else if (color == null){
            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
        }
        this.color=color;

    }

    public Torre (Color color, char columna){
        if (color == null){

            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
        }
        if (columna == 'a' || columna == 'h' ){
           if(color == Color.BLANCO){
               posicion = new Posicion (1,columna);
           }
           else if(color == Color.NEGRO){
               posicion = new Posicion (8,columna);
           }else if (color == null) {
               throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
           }


       }else {
           throw new IllegalArgumentException ("ERROR: Columna no válida.") ;
       }
        this.color=color;

    }

    public void mover (Direccion direccion,int pasos) throws OperationNotSupportedException {
        if (direccion == null ){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");

        }
        if (pasos < 1 ) {
            throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
        }


        Posicion posicionFinal;
        int fila = this.posicion.getFila();
        char columna = this.posicion.getColumna();
        Color color = getColor();
        try{
            switch (direccion){
                case ARRIBA:
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (fila < 8) {
                                fila++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else if (color == Color.NEGRO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (fila > 1) {
                                fila--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }
                    posicionFinal = new Posicion(fila, columna);
                    break;
                case ABAJO:
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (fila > 1) {
                                fila--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }

                    }else if (color == Color.NEGRO){
                        for (int i = 1; i <= pasos; i++) {
                            if (fila < 8) {
                                fila++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }

                    }
                    posicionFinal = new Posicion(fila, columna);
                    break;
                case IZQUIERDA:
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (columna > 'a') {
                                columna--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }else if (color == Color.NEGRO){
                        for (int i = 1; i <= pasos; i++) {
                            if (columna < 'h') {
                                columna++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }

                    }
                    posicionFinal = new Posicion(fila, columna);
                    break;
                case DERECHA:
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (columna < 'h') {
                                columna++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else {
                        for (int i = 1; i <= pasos; i++) {
                            if (columna > 'a') {
                                columna--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }
                    posicionFinal = new Posicion(fila, columna);



                    break;
                default:
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
            }

        }catch (OperationNotSupportedException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }
        this.setPosicion(posicionFinal);

    }

    public void enrocar (Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        Posicion posicionFinal = null;
        int fila = this.posicion.getFila();
        char columna = this.posicion.getColumna();
        Color color = getColor();
        try {
            switch (direccion){
                case ENROQUE_CORTO:
                    if (color == Color.BLANCO && columna == 'h' ){
                        posicionFinal = new Posicion (1,'f');
                    }else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    if(color == Color.NEGRO && columna == 'h'){
                        posicionFinal = new Posicion(8, 'f');

                    }else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    break;
                case ENROQUE_LARGO:
                    if (color == Color.BLANCO && columna == 'a' ){
                        posicionFinal = new Posicion( 1, 'd');
                    }else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    if (color == Color.NEGRO && columna == 'a'){
                        posicionFinal= new Posicion(8,'d');
                    }else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    break;
                default:
                    throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");

            }

        }catch (OperationNotSupportedException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
        }
        this.setPosicion(posicionFinal);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torre torre = (Torre) o;
        return color == torre.color && Objects.equals(posicion, torre.posicion);
    }

    @Override
    public String toString() {
        return "fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ", color=" + color;

    }
    @Override
    public int hashCode() {
        return Objects.hash(color, posicion);
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color != null)
        {
            this.color = color;
        }else {
            throw new NullPointerException ("ERROR: No se puede asignar un color nulo.");
        }



    }

    public Posicion getPosicion() {
        return posicion;
    }

    private void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}

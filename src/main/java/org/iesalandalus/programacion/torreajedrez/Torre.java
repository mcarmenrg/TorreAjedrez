package org.iesalandalus.programacion.torreajedrez;

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
        }else if (color == null)
            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");

    }

    public Torre (Color color, char columna){
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
           throw new IllegalArgumentException ("ERROR: Columna no válida") ;
       }

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

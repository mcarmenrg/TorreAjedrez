package org.iesalandalus.programacion.torreajedrez;

public class Torre
{
    private Color color;
    private Posicion posicion;

    public Torre (){
        color = Color.NEGRO;
        posicion = new Posicion (8, 'h');
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

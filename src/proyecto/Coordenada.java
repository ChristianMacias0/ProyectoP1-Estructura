package proyecto;

import java.util.Objects;

public class Coordenada implements Comparable<Coordenada> {
    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() { return this.fila; }
    public int getColumna() { return this.columna; }

    @Override
    public String toString() {
        return "(" + this.fila + ", " + this.columna + ")";
    }

    @Override
    public int compareTo(Coordenada o) {
        if(this.fila == o.getFila() && this.columna == o.getColumna()){ return 0;}
        if(this.columna != o.getColumna()){return Integer.compare(columna, o.getColumna());}
        return Integer.compare(fila, o.getFila());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparar referencias
        if (obj == null || getClass() != obj.getClass()) return false; // Verificar tipo
        Coordenada coordenada = (Coordenada) obj; // Hacer el casting
        return fila == coordenada.fila && columna == coordenada.columna; // Comparar valores
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna); // Generar un hashcode basado en fila y columna
    }


    //Conseguir coordenadas adyacentes
    public Coordenada getCoordenadaArriba(){
        return new Coordenada(fila-1, columna);
    }
    public Coordenada getCoordenadaAbajo(){
        return new Coordenada(fila+1, columna);
    }
    public Coordenada getCoordenadaIzquierda(){
        return new Coordenada(fila, columna-1);
    }
    public Coordenada getCoordenadaDerecha(){
        return new Coordenada(fila, columna+1);
    }

    //Verificar existencia de coordenadas adyacentes
    public boolean existeCoordenadaArriba(){
        return fila > 0;
    }
    public boolean existeCoordenadaAbajo(){
        try {
            Coordenada c = getCoordenadaAbajo();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean existeCoordenadaIzquierda(){
        return columna > 0;
    }
    public boolean existeCoordenadaDerecha(){
        try {
            Coordenada c = getCoordenadaDerecha();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

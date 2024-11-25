package proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class cluster implements Comparable<cluster> {
    private static int contador = 0;
    int color;
    int tam;
    ArrayList<Coordenada> pixeles;
    int pixelIzq;
    int numeroCloster;

    //Constructor
    public cluster(int color, int tam, int pixelIzq){
        contador++;
        this.color=color;
        this.tam=tam;
        this.pixeles=new ArrayList<>();
        this.pixelIzq=pixelIzq;
        this.numeroCloster=contador;
    }

    public cluster(){
        this(0,0,0);
    }

    

    // Getter y Setter para color
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    // Getter y Setter para tam
    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    // Getter y Setter para pixeles
    public ArrayList<Coordenada> getPixeles() {
        return pixeles;
    }

    public void setPixeles(ArrayList<Coordenada> pixeles) {
        this.pixeles = pixeles;
    }

    // Getter y Setter para pixelIzq
    public int getPixelIzq() {
        return pixelIzq;
    }

    public void setPixelIzq(int pixelIzq) {
        this.pixelIzq = pixelIzq;
    }

    // Getter y Setter para numeroCloster
    public int getNumeroCloster() {
        return numeroCloster;
    }

    public void setNumeroCloster(int numeroCloster) {
        this.numeroCloster = numeroCloster;
    }


    //Compardaor
    @Override
    public int compareTo(cluster o) {
        int tamComparison = Integer.compare(this.getTam(), o.getTam());
        if (tamComparison != 0) {
            return tamComparison;
        }
        return Integer.compare(this.getPixelIzq(), o.getPixelIzq());
    }

    public void actualizarPixelIzq(int pixelIzq) {
        if(pixelIzq < this.pixelIzq){this.pixelIzq = pixelIzq;}
    }

    @Override
    public String toString() {
        return "cluster{" + "tam=" + tam + ", pixeles=" + pixeles + ", pixelIz q=" + pixelIzq + ", numeroCloster=" + numeroCloster +" color: "+ color +"}";
    }


}

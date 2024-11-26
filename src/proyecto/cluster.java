package proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class cluster implements Comparable<cluster> {
    private static int contador = 0;
    private int color;
    private int tam;
    private ArrayList<Coordenada> pixeles;
    private int numeroCloster;
    
    public void setContador(int valor){
        contador=valor;
    }

    //Constructor
    public cluster(int color, int tam){
        contador++;
        this.color=color;
        this.tam=tam;
        this.pixeles=new ArrayList<>();

        this.numeroCloster=contador;
    }

    public cluster(){
        this(0,0);
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
        return tamComparison;
    }


    @Override
    public String toString() {
        return "cluster{" + "tam=" + tam + ", pixeles=" + pixeles  + ", numeroCloster=" + numeroCloster +" color: "+ color +"}";
    }


}

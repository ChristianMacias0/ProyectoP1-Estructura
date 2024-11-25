package proyecto;

import java.util.Queue;

public class main {
    public static void main(String[] args){
        Cuadro cuadro=new Cuadro("Matriz.txt");
        System.out.println(cuadro.matriz[0][0]);
        Queue<cluster> cola= cuadro.buscarClusters();
        System.out.println(cola.size());
        while(!cola.isEmpty()){
            System.out.println(cola.poll());
        }
        System.out.println(cola);

    }
    
}

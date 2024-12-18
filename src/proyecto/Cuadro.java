package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import proyecto.cluster;

public class Cuadro{
    
    public int[][] matriz;
    public int fila;
    public int columna;
    Queue<cluster> cola;
    
    public int[][] getMatriz(){
        return matriz;
    }
    public Queue<cluster> getCola(){
        return cola;
    }


    public Cuadro(String texto ){
        try(BufferedReader br=new BufferedReader(new FileReader(texto))){
            String linea;
            linea=br.readLine();//primera lectura para sacar las filas
            this.fila=Integer.parseInt(linea);
            linea=br.readLine();//segunda lectura para sacar las columnas
            this.columna=Integer.parseInt(linea);
            int[][] mat=new int[this.fila][this.columna];//matriz
            
            for(int i=0;i<fila;i++){//recorre las filas                
                linea=br.readLine();
                String[] lista=linea.split(",");
                for(int b=0;b<columna;b++){//recorre las columnas
                    mat[i][b]=Integer.parseInt(lista[b]);//se usa el valor de b para agregar los datos en cada columna de cada fila    
                }
            }
            this.matriz=mat;//indica el valor de la matriz
            this.cola=this.buscarClusters();
            // crear el Array, matriz, lista(como prefieras guardar los datos) de closters
            //para eso esta el metodo buscar closters, que recive la matriz y debe buscar todos los closters
        }catch(IOException e){
            System.out.println(e);
        }

        
    }

    public Queue<cluster> buscarClusters() {
        List<cluster> resultado = new ArrayList<>();
        Set<Coordenada> visitadas = new HashSet<>();
    
        for (int filaAct = 0; filaAct < matriz.length; filaAct++) {
            for (int columnaAct = 0; columnaAct < matriz[0].length; columnaAct++) {
                Coordenada inicial = new Coordenada(filaAct, columnaAct);
    
                // Si la coordenada ya fue visitada, la ignoramos
                if (visitadas.contains(inicial)) {
                    continue;
                }
    
                // Iniciar un nuevo cluster
                cluster nuevoCluster = new cluster();
                Stack<Coordenada> pila = new Stack<>();
                int colorActual = matriz[filaAct][columnaAct]; // Color del cluster
                pila.push(inicial);
    
                while (!pila.isEmpty()) {
                    Coordenada actual = pila.pop();
    
                    // Si ya fue visitada, no la procesamos de nuevo
                    if (visitadas.contains(actual)) {
                        continue;
                    }
    
                    // Marcar la coordenada como visitada
                    visitadas.add(actual);
    
                    // Agregar al cluster actual
                    nuevoCluster.getPixeles().add(actual);
                    nuevoCluster.setTam(nuevoCluster.getTam() + 1);
                    nuevoCluster.setColor(colorActual);
    
                    // Explorar las coordenadas adyacentes del mismo color
                    for (Coordenada vecino : getAdyacentes(actual)) {
                        // Asegurarse de que la coordenada sea válida y no haya sido visitada
                        if (esValida(vecino) &&
                            matriz[vecino.getFila()][vecino.getColumna()] == colorActual && // Verifica que los colores sean iguales
                            !visitadas.contains(vecino)) {
                            pila.push(vecino); // Agregar a la pila para explorar
                        }
                    }
                }
    
                // Añadimos el cluster a la lista de resultados si tiene píxeles
                if (nuevoCluster.getTam() > 0) {
                    resultado.add(nuevoCluster);
                }
            }
        }

        // Ahora, ordenar los clusters por tamaño (descendente) y píxel más a la izquierda
        resultado.sort((c1, c2) -> {
            // Comparar por tamaño (descendente)
            int cmp = Integer.compare(c2.getTam(), c1.getTam());
            if (cmp == 0) {
                // En caso de empate, comparar por el píxel más a la izquierda
                Coordenada minC1 = obtenerPixelMasIzquierdo(c1);
                Coordenada minC2 = obtenerPixelMasIzquierdo(c2);
                
                cmp = Integer.compare(minC1.getColumna(), minC2.getColumna());
            }
            return cmp;
        });

        return new LinkedList<>(resultado); // Convertimos de List a Queue
    }



    private List<Coordenada> getAdyacentes(Coordenada coord) {
        List<Coordenada> adyacentes = new ArrayList<>();
        adyacentes.add(new Coordenada(coord.getFila() - 1, coord.getColumna())); // Arriba
        adyacentes.add(new Coordenada(coord.getFila() + 1, coord.getColumna())); // Abajo
        adyacentes.add(new Coordenada(coord.getFila(), coord.getColumna() - 1)); // Izquierda
        adyacentes.add(new Coordenada(coord.getFila(), coord.getColumna() + 1)); // Derecha
        return adyacentes;
    }

    private boolean esValida(Coordenada coord) {
        return coord.getFila() >= 0 && coord.getFila() < this.fila &&
               coord.getColumna() >= 0 && coord.getColumna() < this.columna;
    }

    private Coordenada obtenerPixelMasIzquierdo(cluster c) {
        return c.getPixeles().stream()
                .min((p1, p2) -> {
                    int cmp = Integer.compare(p1.getColumna(), p2.getColumna());
                    return cmp;
                }).orElse(null);
    }
    

    public void pintarCuadro(int closter, int color){
        ArrayList<cluster> cola=new ArrayList<>(this.cola);
        
        cluster clost=null;
        System.out.println(clost);
        for(cluster clo:cola){
            if(clo.getNumeroCloster()==closter){
                clost=clo;
            }
        }
        if(clost==null)return;
        ArrayList<Coordenada> pixeles=clost.getPixeles();
        System.out.println(clost);
        for(Coordenada cor:pixeles){
            int fil=cor.getFila();
            int col=cor.getColumna();
            matriz[fil][col]=color;
        }

        
    }


}
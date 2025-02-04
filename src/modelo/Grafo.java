/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author MINEDUCYT
 */
public class Grafo<T> {
private ArrayList<Vertice> vertices;
    private ArrayList<ArrayList> adyacentes;
    private int[][] matrizAdy;
    private int[][] matrizCamino;
    private ArrayList<Vertice> maercados;// almacena los vetices marcados osea los que ya se visitaron
    private boolean dirigido;

    public Grafo() {
        this.vertices = new ArrayList();
        this.adyacentes = new ArrayList();
        this.matrizAdy = new int[50][50];
        this.matrizCamino = new int[50][50];
        this.maercados = new ArrayList();
        dirigido();
    }

    public void dirigido() {
        String c;

        do {
            c = JOptionPane.showInputDialog("Es dirigido? s/otro");
        } while (c == null);

        c = c.toLowerCase();
        if (c.equals("s")) {
            dirigido = true;
        } else {
            dirigido = false;
        }

    }

    public boolean insertar(Vertice v) {//insertamos vertices

        if (!existe(v)) {

            this.vertices.add(v);
            this.adyacentes.add(new ArrayList());
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe el vertice");
            return false;
        }
    }

    private boolean existe(Vertice v) {
        for (Vertice x: vertices) {
            if (((String)v.getV()).compareToIgnoreCase((String)x.getV())==0) {
                return true;
            }
        }
        return this.vertices.contains(v);
    }

    public boolean crearArco(Vertice org, Vertice dest) {
        boolean arco;
        if (dirigido) {
            arco = insertarArco(org, dest);
        } else {
            if (org != dest) {
                arco = insertarArco(org, dest);
                arco = insertarArco(dest, org);
            } else {
                arco = insertarArco(org, dest);
            }
        }

        return arco;
    }

    private boolean insertarArco(Vertice org, Vertice dest) {
        int indexOrg;
        boolean arco = false;
        if (existe(org) && existe(dest)) {
            indexOrg = vertices.indexOf(org);
            if (!existeAdyacente(indexOrg, dest)) {
                ArrayList aux = this.adyacentes.get(indexOrg);
                aux.add(dest);
                this.adyacentes.set(indexOrg, aux);
            }
        }
        matrizAdy();
        return arco;

    }

    private boolean existeAdyacente(int inderOrig, Vertice dest) {

        return this.adyacentes.get(inderOrig).contains(dest);

    }

    public void matrizAdy() {

        for (int f = 0; f < vertices.size(); f++) {
            for (int c = 0; c < vertices.size(); c++) {

                Vertice v=vertices.get(c);
                if (existeAdyacente(f,v)) {
                    this.matrizAdy[f][c]=1;
                }else{
                    this.matrizAdy[f][c] = 0;
                }
                
            }
        }
    }
    
    public ArrayList profundidad(){// este es una cola
        ArrayList salida = new ArrayList();
        this.maercados.clear();
        Stack pilita = new Stack();
        int i = 0;// iniciamos con eso para hagarar el vertice que esta en la posicion 0
        while(this.vertices.size() != this.maercados.size()){ // para visitar los vertices uno por uno  mientras que los vetices no sean iguales los tamaños con los tamaños de los marcados que se repita porque quiere decir q aun ay vetices que no emos vistido
            Vertice v = this.vertices.get(0); //agarramos primer vetice
            if(!marcado(v)){ //Si el vetice no esta marcado
                this.maercados.add(v); // lo marcamos
                pilita.push(v);//lo ingresamos en la pila
            }
            i++;//para aumentar y avanzar en el siguiente vertice
            //repitieramos a partir del paso paso para que metieramos todos los adyacentes del vetice que emos marcado a la pia como pudene existir mas de un vetice adyacente necesitamos una estructura while para revisar varias veces para hagarar el vertice adyacente y meterlo a la estrucutra
            while(!pilita.empty()){//si la pilita no esta vacia 
                Vertice procesado = (Vertice) pilita.pop(); //sacamos el que esta en la pila lo mandamos a pantalla
                salida.add(procesado);//como tenemos un arrayLista  llamado salida para mandarlo a la vista(pantalla) lo mandamos   aqui ya esta listo para mandar los adyacentes
                int indexV = this.vertices.indexOf(procesado); //por si queremos saber en que posicion esta el que emos procesado osea el indice del que emos procesado para que sirve saber el indice para poder buscar en el arreglo de los adyacente todos los adyacentes de este vertice  como el vertice esta en unn arreglo llamado vertices vamos y lo sacamos de ahi como ya lo obtuvimos asemos lo siguiente
                ArrayList<Vertice> aux = this.adyacentes.get(indexV);//aqui estan todos los adyacentes del vertice procesado
                for(Vertice x: aux){//recorremos todos los verices que tenemos en auxiliar
                    if(!marcado(x)){// si no estan marcado ese vertice 
                        this.maercados.add(x);// lo marcamos
                        pilita.push(x);//lo metemos a la pilita
                    }
                }
            }
            
        }
        return salida;// lo mandamos a pantalla
    }
    
     public ArrayList anchura(){// este es una cola
        ArrayList salida = new ArrayList();
        this.maercados.clear();
        Queue colita = new LinkedList();
        int i = 0;// iniciamos con eso para hagarar el vertice que esta en la posicion 0
        while(this.vertices.size() != this.maercados.size()){ // para visitar los vertices uno por uno  mientras que los vetices no sean iguales los tamaños con los tamaños de los marcados que se repita porque quiere decir q aun ay vetices que no emos vistido
            Vertice v = this.vertices.get(0); //agarramos primer vetice
            if(!marcado(v)){ //Si el vetice no esta marcado
                this.maercados.add(v); // lo marcamos
                colita.offer(v);//lo ingresamos en la pila
            }
            i++;//para aumentar y avanzar en el siguiente vertice
            //repitieramos a partir del paso paso para que metieramos todos los adyacentes del vetice que emos marcado a la pia como pudene existir mas de un vetice adyacente necesitamos una estructura while para revisar varias veces para hagarar el vertice adyacente y meterlo a la estrucutra
            while(!colita.isEmpty()){//si la pilita no esta vacia 
                Vertice procesado = (Vertice) colita.poll(); //sacamos el que esta en la pila lo mandamos a pantalla
                salida.add(procesado);//como tenemos un arrayLista  llamado salida para mandarlo a la vista(pantalla) lo mandamos   aqui ya esta listo para mandar los adyacentes
                int indexV = this.vertices.indexOf(procesado); //por si queremos saber en que posicion esta el que emos procesado osea el indice del que emos procesado para que sirve saber el indice para poder buscar en el arreglo de los adyacente todos los adyacentes de este vertice  como el vertice esta en unn arreglo llamado vertices vamos y lo sacamos de ahi como ya lo obtuvimos asemos lo siguiente
                ArrayList<Vertice> aux = this.adyacentes.get(indexV);//aqui estan todos los adyacentes del vertice procesado
                for(Vertice x: aux){//recorremos todos los verices que tenemos en auxiliar
                    if(!marcado(x)){// si no estan marcado ese vertice 
                        this.maercados.add(x);// lo marcamos
                        colita.offer(x);//lo metemos a la pilita
                    }
                }
            }
            
        }
        return salida;// lo mandamos a pantalla
    }
     
    public void addPesos(){//agregar el peso el peso es el peso de cada arista o costo como es matrix se ase lo siguiente
        for (int f = 0; f < this.vertices.size(); f++) {
            for (int c = 0; c < this.vertices.size(); c++) {
                this.matrizCamino[f][c]=0; // inicializamos las filas y las columnas con 0
               // verificar si existen pesos para cada una de esas aristas  si ay un 1 es donde ay una arista
              // i=j si eran iguales agregamos cero (i y j son vertices)
              // si no son iguales verificamos siexistian adyacentes es porque ay una arista y si ay 1 en la matriz de adyacencia significa que ay una arista y pedimos el peso
                
            }
        }int n;
        for (int f = 0; f < this.vertices.size(); f++) { // f para filas
            for (int c = 0; c < this.vertices.size(); c++) { //c para columnas
                    // agarramos los vertices (agarrar vertice que esta en la posicion fila y luego el de la siguiente columna y si son iguales q almacenaramo cero )
                    if(this.vertices.get(f)== this.vertices.get(c)){ // deme el vetice de la pocicion fila  y verificamos si es el mismo de columna si son iguales ponemos 0 en la matriz
                    this.matrizCamino[f][c]=0;
                    }else{// si no son iguales devemos saber si en la matriz de adyacencia ay algun 1 o 0  
                   if(this.matrizAdy[f][c]== 1 && this.matrizCamino[f][c] ==0){ // si en la matriz de adyacencia  ay un 1  y si en la matriz de camino ay un 0 entonces guardamos un peso
                       String s;

                       do {
                           s = JOptionPane.showInputDialog("Peso para"+this.vertices.get(c)+"------>"+this.vertices.get(c));

                           //como necesitamos valor como entero y no como cadena devmos combertir 
                         if(s == null){// si el usuario no agrego nada 
                           s="-1";
                           }
                           n = Integer.parseInt(s);// ya convertimos a un numero podemos ocupar tambien el caso de usar un try catch paa ver si el usuario uso numero y no letras
                         
                      } while (n <= 0);//si es un numero menor o igual a cero vuelvaselo a pedir al usuario pero si es mayor a cero quiere decir q ya tenemos un peso(osea una distacia esos es el peso)
                       //como ya tenemos la distancia verificamos si el grafo es dirigido o no dirigido
                       if (dirigido) {// si es dirigido solo una ves agregaremos el peso
                           this.matrizCamino[f][c]=n;// guarde en la matriz de camino en la posicion fila columna y guardde el valor 
                       }else{//si no es dirigido devemos agregarlo en los 2 sentidos
                           //si no es dirigido(osea la matriz es cimetrica) vamos a guardar en los 2 sentidos 
                      this.matrizCamino[f][c]=n;
                      this.matrizCamino[c][f]=n;
                       
                       }

                    }else{// si no es igual a 1 significa que no ay un camino directo vamos a guardar infinito
                       //guardar en la pocicion fila columna guardamos un infinito
                       this.matrizCamino[f][c]= 1000;// por ahora esta el 1000 pero luego lo cambiaremos por el caracter infito para verlo e pantalla
                       
                   }
                  }
              }
        }
}
    
    
    
    public <T extends Comparable> Vertice getVerticer(T contenido){
        for (Vertice x: this.vertices)
        // compare de x agarre el contenido
        if(contenido.compareTo(x.getV())==0){  //de x compare el contenido  si es igual a cer es porQue lo encontro 
         return x;// retorna el vertice
        }
            return null;//no lo encontro 
    }
    
    
    private boolean marcado(Vertice v){
        return this.maercados.contains(v);//contains si lo contiene  si lo contiene mandara que si o que no       
    }

    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<ArrayList> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<ArrayList> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }

    public int[][] getMatrizCamino() {
        return matrizCamino;
    }

    public void setMatrizCamino(int[][] matrizCamino) {
        this.matrizCamino = matrizCamino;
    }

    public ArrayList<Vertice> getMaercados() {
        return maercados;
    }

    public void setMaercados(ArrayList<Vertice> maercados) {
        this.maercados = maercados;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }
    
    
}
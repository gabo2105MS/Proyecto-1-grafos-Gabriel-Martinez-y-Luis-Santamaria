/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.util.HashMap;


import java.util.Map;

/**
 *
 * @author gabri
 * 
 * 1 - 2 - 4
 * 2 -3
 * 3
 * 4
 * 
 */
public class Grafo {
    private Nodo_Grafo[] nodos;
    private boolean[][] matrizAdyacencia;
    private Map<String, Integer> usuarioIndiceMap;

    public Grafo(int numNodos) {
        nodos = new Nodo_Grafo[numNodos];
        matrizAdyacencia = new boolean[numNodos][numNodos];
        usuarioIndiceMap = new HashMap<>();
    }

    public void agregarNodo(int indice, Nodo_Grafo nodo) {
        nodos[indice] = nodo;
        usuarioIndiceMap.put(nodo.getUsuario(), indice);
    }

    public void agregarRelacion(String usuarioOrigen, String usuarioDestino) {
        if (usuarioIndiceMap.containsKey(usuarioOrigen) && usuarioIndiceMap.containsKey(usuarioDestino)) {
            int indiceOrigen = usuarioIndiceMap.get(usuarioOrigen);
            int indiceDestino = usuarioIndiceMap.get(usuarioDestino);
            matrizAdyacencia[indiceOrigen][indiceDestino] = true;
        } else {
            System.err.println("Alguno de los usuarios no existe en el grafo.");
        }
    }

    // Resto de las funciones sin cambios...

    // Función para buscar un nodo por su nombre de usuario
    public int buscarNodoPorUsuario(String usuario) {
        if (usuarioIndiceMap.containsKey(usuario)) {
            return usuarioIndiceMap.get(usuario);
        }
        return -1; // Retorna -1 si no se encuentra el nodo
    }

    // Función para buscar una relación entre usuarios
    public boolean buscarRelacion(String usuarioOrigen, String usuarioDestino) {
        if (usuarioIndiceMap.containsKey(usuarioOrigen) && usuarioIndiceMap.containsKey(usuarioDestino)) {
            int indiceOrigen = usuarioIndiceMap.get(usuarioOrigen);
            int indiceDestino = usuarioIndiceMap.get(usuarioDestino);
            return matrizAdyacencia[indiceOrigen][indiceDestino];
        } else {
            System.err.println("Alguno de los usuarios no existe en el grafo.");
            return false;
        }
    }
}
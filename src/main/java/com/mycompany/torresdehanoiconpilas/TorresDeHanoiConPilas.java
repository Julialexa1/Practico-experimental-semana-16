//Resolución del problema de las Torres de Hanoi
//Desarrolle un algoritmo que resuelva el problema de las Torres de Hanoi utilizando pilas. 
//El programa debe mostrar paso a paso cómo se mueven los discos entre las torres.
package com.mycompany.torresdehanoiconpilas;

import java.util.Stack;

public class TorresDeHanoiConPilas {

    // Método que mueve discos recursivamente de origen a destino usando auxiliar
    public static void resolverTorres(int n, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar, String nombreOrigen, String nombreDestino, String nombreAuxiliar) {
        if (n == 1) {
            moverDisco(origen, destino, nombreOrigen, nombreDestino);
            return;
        }

        resolverTorres(n - 1, origen, auxiliar, destino, nombreOrigen, nombreAuxiliar, nombreDestino);
        moverDisco(origen, destino, nombreOrigen, nombreDestino);
        resolverTorres(n - 1, auxiliar, destino, origen, nombreAuxiliar, nombreDestino, nombreOrigen);
    }

    // Método que simula el movimiento de un disco
    private static void moverDisco(Stack<Integer> origen, Stack<Integer> destino, String nombreOrigen, String nombreDestino) {
        int disco = origen.pop();
        destino.push(disco);
        System.out.println("Mover disco " + disco + " desde " + nombreOrigen + " hacia " + nombreDestino);
    }

    // Método principal
    public static void main(String[] args) {
        int numDiscos = 3;

        Stack<Integer> torreA = new Stack<>();
        Stack<Integer> torreB = new Stack<>();
        Stack<Integer> torreC = new Stack<>();

        // Llenamos la torre A con los discos (mayor abajo)
        for (int i = numDiscos; i >= 1; i--) {
            torreA.push(i);
        }

        System.out.println("Resolviendo Torres de Hanoi con " + numDiscos + " discos:");
        resolverTorres(numDiscos, torreA, torreC, torreB, "A", "C", "B");
    }
}

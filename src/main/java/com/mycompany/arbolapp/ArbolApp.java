
package com.mycompany.arbolapp;

import java.util.*;

// Clase Nodo para representar cada elemento del árbol
class Nodo {
    String dato;
    Nodo izquierdo, derecho;

    public Nodo(String dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Clase ArbolBinario
class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Insertar de forma recursiva (alfabéticamente)
    public Nodo insertar(Nodo nodo, String valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.dato) > 0) {
            nodo.derecho = insertar(nodo.derecho, valor);
        }
        return nodo;
    }

    // Recorridos
    public void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecho);
        }
    }

    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }
}

// Clase principal
public class ArbolApp {
    public static void main(String[] args) {
        ArbolBinario arbol1 = new ArbolBinario();
        ArbolBinario arbol2 = new ArbolBinario();

        // Bloque de notas 1 (Cursos de informática)
        String[] datos1 = {"Algoritmos", "Bases de Datos", "Compiladores", "Estructuras", "Java"};
        for (String dato : datos1) {
            arbol1.raiz = arbol1.insertar(arbol1.raiz, dato);
        }

        // Bloque de notas 2 (Árbol de nombres de personas)
        String[] datos2 = {"Carlos", "Ana", "Pedro", "Lucía", "María"};
        for (String dato : datos2) {
            arbol2.raiz = arbol2.insertar(arbol2.raiz, dato);
        }

        // Reportería de Árbol 1
        System.out.println("Árbol 1 (Cursos de Informática):");
        System.out.print("PreOrden: "); arbol1.preOrden(arbol1.raiz); System.out.println();
        System.out.print("InOrden: "); arbol1.inOrden(arbol1.raiz); System.out.println();
        System.out.print("PostOrden: "); arbol1.postOrden(arbol1.raiz); System.out.println();

        System.out.println("\n----------------------------");

        // Reportería de Árbol 2
        System.out.println("Árbol 2 (Nombres de Personas):");
        System.out.print("PreOrden: "); arbol2.preOrden(arbol2.raiz); System.out.println();
        System.out.print("InOrden: "); arbol2.inOrden(arbol2.raiz); System.out.println();
        System.out.print("PostOrden: "); arbol2.postOrden(arbol2.raiz); System.out.println();
    }
}

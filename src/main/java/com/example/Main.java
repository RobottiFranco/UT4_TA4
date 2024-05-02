package com.example;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();

        // insertar los elementos 12, 25, 14, 1, 33, 88, 45, 2, 7, 66,5, 99
        arbol.insertar(new TElementoAB(12, null));
        arbol.insertar(new TElementoAB(25, null));
        arbol.insertar(new TElementoAB(14, null));
        arbol.insertar(new TElementoAB(1, null));
        arbol.insertar(new TElementoAB(33, null));
        arbol.insertar(new TElementoAB(88, null));
        arbol.insertar(new TElementoAB(45, null));
        arbol.insertar(new TElementoAB(2, null));
        arbol.insertar(new TElementoAB(7, null));
        arbol.insertar(new TElementoAB(66, null));
        arbol.insertar(new TElementoAB(5, null));
        arbol.insertar(new TElementoAB(69, null));
        arbol.insertar(new TElementoAB(99, null));

        System.out.println(arbol.obtenerCantidadHojas());
/*         System.out.printf("%s " + arbol.inOrden() + "\n", "Inorden");

        System.out.println("¿Existe elemento 100? " + (arbol.buscar(100) != null));
        System.out.println("¿Existe elemento 10? " + (arbol.buscar(10) != null));
        System.out.println("¿Existe elemento 7? " + (arbol.buscar(7) != null));
        System.out.println("¿Existe elemento 23? " + (arbol.buscar(23) != null));

        System.out.println("Eliminando nodos...");

        arbol.eliminar(99);
        arbol.eliminar(15);
        arbol.eliminar(2);
        arbol.eliminar(77);
        arbol.eliminar(33);

        // eliminar los elementos 99, 15, 2, 12, 77, 33 y volver a emitir el inorden....
        System.out.printf("%s " + arbol.inOrden() + "\n", "Inorden");
        System.out.printf("%s " + arbol.preOrden() + "\n", "Preorden");
        System.out.printf("%s " + arbol.postOrden() + "\n", "Postorden"); */
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

/**
 *
 * @author sala304
 */
public class ListaEstudiantes {

    class nodo {

        Estudiantes estudiantes;

        nodo sig;

        public nodo(Estudiantes estudiantes) {
            this.estudiantes = estudiantes;
        }

        public Estudiantes getEstudiantes() {
            return estudiantes;
        }

        public void setEstudiantes(Estudiantes estudiantes) {
            this.estudiantes = estudiantes;
        }

    }//Fin clase nodo

    private nodo raiz, fondo;

    public ListaEstudiantes() {
        raiz = null;
        fondo = null;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFinal(Estudiantes e) {
        nodo nuevo;
        nuevo = new nodo(e);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public void imprimir() {
        nodo reco = raiz;
        System.out.println("Listado de estudiantes: ");
        while (reco != null) {
            reco.estudiantes.imprimir();
            reco = reco.sig;
        }
        System.out.println();
    }

}

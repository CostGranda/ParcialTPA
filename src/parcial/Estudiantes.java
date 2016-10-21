/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

import java.io.IOException;

/**
 *
 * @author sala304
 */
public class Estudiantes {

    class nodo {

        public String nombre, documento;
        public float seguimiento;
        public float parcial1;
        public float parcial2;
        public float notafinal;

        nodo sig;

        public nodo(String documento, String nombre, float parcial1, float parcial2, float seguimiento, float notafinal) {
            this.nombre = nombre;
            this.documento = documento;
            this.parcial1 = parcial1;
            this.parcial2 = parcial2;
            this.seguimiento = seguimiento;
            this.notafinal = notafinal;
        }

        public void setNotafinal(float notafinal) {
            this.notafinal = notafinal;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDocumento() {
            return documento;
        }

        public float getSeguimiento() {
            return seguimiento;
        }

        public float getParcial1() {
            return parcial1;
        }

        public float getParcial2() {
            return parcial2;
        }

        public float getNotafinal() {
            return notafinal;
        }
        
        

    }//Fin clase nodo

    private nodo raiz, fondo;

    public Estudiantes() {
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

    public void insertarFinal(String documento, String nombre, float parcial1, float parcial2, float seguimiento, float notafinal) {
        nodo nuevo;
        nuevo = new nodo(documento, nombre, parcial1, parcial2, seguimiento, notafinal);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public boolean validarSiExiste(String documento) {
        nodo reco = raiz;
        boolean existe = false;
        while (reco != null) {
            if (reco.documento == documento) {
                existe = true;
            }
            reco = reco.sig;
        }
        return existe;
    }

    /*    public String nombreEmp(String documento){
    nodo reco = raiz;
    String nombreEmp = null;
    while (reco != null) {
    if (reco.documento.equals(documento)) {
    nombreEmp = reco.nombreEmp;
    }
    }
    return nombreEmp;
    }*/
    public void imprimir() {
        nodo reco = raiz;
        System.out.println("Listado de estudiantes: ");
        while (reco != null) {
            System.out.printf("Cedula: %s - Nombre: %s - Parcial1: %.2f - Parcial2: %.2f - Segumiento: %.2f - NOTA FINAL: %.2f \n",
                    reco.documento, reco.nombre, reco.parcial1, reco.parcial2, reco.seguimiento, reco.notafinal);
            reco = reco.sig;
        }
        System.out.println();
    }

    public void imprimirInfo(String documento) {
        nodo reco = raiz;
        System.out.println("Información del estudiante:");
        while (reco != null) {
            if (reco.documento.equals(documento)) {
                System.out.printf("Cedula: %s - Nombre: %s - Parcial1: %.2f - Parcial2: %.2f - Segumiento: %.2f - NOTA FINAL: %.2f \n",
                        reco.documento, reco.nombre, reco.parcial1, reco.parcial2, reco.seguimiento, reco.notafinal);
            }
            reco = reco.sig;
        }
        System.out.println();
    }

    public void imprimirGanadores() {
        nodo reco = raiz;
        System.out.println("Estudiantes que ganaron la materia: ");
        while (reco != null) {
            if (reco.notafinal >= 3) {
                System.out.printf("Cedula: %s - Nombre: %s - Parcial1: %.2f - Parcial2: %.2f - Segumiento: %.2f - NOTA FINAL: %.2f \n",
                        reco.documento, reco.nombre, reco.parcial1, reco.parcial2, reco.seguimiento, reco.notafinal);
            }
            reco = reco.sig;
        }
        System.out.println();
    }

    public ListaEstudiantes listaClietne(float nota) throws IOException {
        nodo reco = raiz;
        ListaEstudiantes le = new ListaEstudiantes();
        System.out.println("Estudiantes que ganaron la materia: ");
        while (reco != null) {
            if (reco.notafinal > nota) {
                le.insertarFinal(this);
//                System.out.printf("Cedula: %s - Nombre: %s - Parcial1: %.2f - Parcial2: %.2f - Segumiento: %.2f - NOTA FINAL: %.2f \n",
//                        reco.documento, reco.nombre, reco.parcial1, reco.parcial2, reco.seguimiento, reco.notafinal);
            }
            reco = reco.sig;
        }

        System.out.println();
        return le;
        
    }
    


}

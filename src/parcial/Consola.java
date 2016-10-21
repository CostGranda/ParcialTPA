/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

import CLIENTE.inicioCliente;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sebgv
 */
public class Consola {

    Scanner teclado = new Scanner(System.in);
    String cedula;
    String nombre;
    float parcial1, parcial2, seguimiento;

    float nota;
    Estudiantes estudiantes = new Estudiantes();

    public void menuPrincipal() throws IOException, ClassNotFoundException {
        String op;
        String op2 = "si";

        System.out.print("********************************************** \n"
                + "*    Bienvenido                           *\n"
                + "*******************************************\n"
                + "*   1. Registrar estudiante                 *\n"
                + "*   2. Listar todo                          *\n"
                + "*   3. Listar Ganadores                     *\n"
                + "*   3. Listar Ganadores                     *\n"
                + "*   5. Listar A traves de sockets           *\n"
                + "*   8. Salir                                *\n"
                + "*******************************************\n");
        op = teclado.next();

        switch (op) {
            case "1":
                while ("si".equals(op2)) {
                    System.out.println("Ingrese la cedula del estudiante: ");
                    cedula = teclado.next();
                    System.out.println("Ingrese el nombre del estudiante: ");
                    nombre = teclado.next();
                    System.out.println("Ingrese la nota del primer parcial: ");
                    parcial1 = teclado.nextFloat();
                    System.out.println("Ingrese la nota del segundo parcial: ");
                    parcial2 = teclado.nextFloat();
                    System.out.println("Ingrese la nota del seguimiento: ");
                    seguimiento = teclado.nextFloat();
                    if (estudiantes.validarSiExiste(cedula)) {
                        System.out.println("El estudiante con cedula: " + cedula + " ya existe.");
                    } else {
                        float nota = calcularnotafinal(parcial1, parcial2, seguimiento);
                        estudiantes.insertarFinal(cedula.toUpperCase(), nombre, parcial1, parcial2, seguimiento, nota);
                    }
                    System.out.println("¿Desea registrar otro estudiante?");
                    op2 = teclado.next();
                }
                if ("no".equals(op2)) {
                    System.out.println("");
                    menuPrincipal();
                }

                break;
            case "2":
                estudiantes.imprimir();
                menuPrincipal();

            case "3":
                estudiantes.imprimirGanadores();
                menuPrincipal();

                break;
            case "4":
                System.out.println("Ingrese la cedula del estudiante: ");
                cedula = teclado.next();
                estudiantes.imprimirInfo(cedula);
                menuPrincipal();
                break;

            case "5":

                System.out.println("Ingrese la nota del estudiante: ");
                nota = teclado.nextFloat();
                servidorTCP.iniciar();

                ListaEstudiantes le = new ListaEstudiantes();
                le = estudiantes.listaClietne(nota);
                le.imprimir();
                menuPrincipal();
                break;

            default:
                System.out.println("No se reconoce la opcion insertada. Intente de nuevo.");
                menuPrincipal();
        }
    }

    public float calcularnotafinal(float parcial1, float parcial2, float seguimiento) {
        float nota = (float) ((parcial1 * 0.25) + (parcial2 * 0.25) + (seguimiento * 0.50));
        return nota;
    }
}

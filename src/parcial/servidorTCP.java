/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import java.net.*;
import java.io.*;

public class servidorTCP {

    static ServerSocket ss;

    public static void iniciar() throws IOException {
        ss = new ServerSocket(12345, 30000);
        escuchar();
    }//iniciar

    public static void escuchar() throws IOException {
        Socket s;
        while (true) {
            System.out.println("Servidor-> Esperando cliente...");
            s = ss.accept();
            System.out.println("Servidor-> Cliente conectado - " + s.getInetAddress());
            recibir(s);

        }//while    
    }//inicio

    public static void recibir(Socket s) throws IOException {
        String cadena;
        try {
            DataInputStream entrada = new DataInputStream(s.getInputStream());
            while (true) {
                cadena = entrada.readUTF();
                System.out.println("Servidor-> " + cadena);
                enviarObjeto(s, cadena);
                if (cadena == "salir") {
                    break;
                }
            }//while
        } catch (Exception ioe) {
            System.out.println("Servidor-> Cliente desconectado");
            escuchar();
        }

    }//recibir

    public static void enviarObjeto(Socket s, String cadena) throws IOException {

        //objeto
        float nota = Float.parseFloat(cadena);
        ListaEstudiantes le = new ListaEstudiantes();
        Estudiantes e = new Estudiantes();
        le = e.listaClietne(nota);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(le);

    }//enviar

}//clase

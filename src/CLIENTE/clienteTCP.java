package CLIENTE;

import java.net.*;
import java.io.*;
import parcial.Estudiantes;
import parcial.ListaEstudiantes;
class clienteTCP {

    static Socket s;

    public Socket enviars() {
        return s;
    }

    public static boolean conectar() throws ClassNotFoundException {
        boolean confirm = false;
        try {
            s = new Socket("127.0.0.1", 12345); //se crea con: la IP y el puerto
            confirm = true;
            System.out.println("Conectado a: " + s.getInetAddress());

        } catch (IOException ex) {
            System.out.println("No hay conexión");
        }
        return confirm;
    }

    public static void enviar(String dato) throws IOException, ClassNotFoundException {
        DataOutputStream salida = new DataOutputStream(s.getOutputStream());
        salida.writeUTF(dato);
        recibirObjeto(s);
    }//enviar

    public static void cerrar() throws IOException {
        s.close();
    }//cerrar

    public static void recibirObjeto(Socket s) throws IOException, ClassNotFoundException {

        ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());
        ListaEstudiantes le = null;
        le = (ListaEstudiantes) entrada.readObject();
        le.imprimir();

    }//recibir

}//clase


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIENTE;

import java.io.*;

public class inicioCliente {
      
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        String dat;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean rta=clienteTCP.conectar();
    
        
        if(rta){
            while(true){
            System.out.print("\nCliente-> ");
            dat = br.readLine();
        

            if(dat.equals("salir")){
                clienteTCP.cerrar();
                break;
            }else{
                clienteTCP.enviar(dat);   
            
            }
            
            }//while
            
        }// if rta
          
          System.out.println("Cliente cerrado");
             
    }//main
    
    
}
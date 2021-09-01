/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author juice
 */
public class Registro implements Serializable{
    String cadenita;
    ArrayList<Registro> list;
    
    public Registro(){
    list = new ArrayList<>();
}
    public Registro(String cadenita){
    this.cadenita = cadenita;
}

    public String getCadenita() {
        return cadenita;
    }

    public void setCadenita(String cadenita) {
        this.cadenita = cadenita;
    }

    public ArrayList<Registro> getList() {
        return list;
    }

    public void setList(ArrayList<Registro> list) {
        this.list = list;
    }
    
    @Override
   public String toString() {
        return ("\n"+"************"+"\n"+"Registro: "+this.getCadenita());
   }
   
   public void recuperar(String cadenita){
       setCadenita(cadenita);
       agregar();
   }
   
   public void agregar(){
       Registro regis = new Registro();
       regis.setCadenita(cadenita);
       list.add(regis);
   }
   
   
   public void mostrar(){
       if(list.isEmpty()){
           System.out.println("La lista esta vacia");
       }else{
           JOptionPane.showMessageDialog(null,list);
       }
   }
   
   public void menucontrol(){
       Scanner entrada = new Scanner(System.in);
       int opcion;
       System.out.println("CRUD");
       opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la opción correspondiente a la operación a realizar, se guardara unicamente lo que esta mostrandose en el Display, si no guarda los registros, serán almacenados unicamente en Caché"+ "\n"
               + "1. Guardar registros"
               + "\n"
               + "2. Recuperar Registros"
               + "\n"
               +"3. Mostrar Registros"));
       
       switch (opcion) {
           case 1:
               serializar();
           case 2:
               leer();
           case 3:
               mostrar();
       }
   }
   
   public void serializar(){
         try
        {
            FileOutputStream fos = new FileOutputStream("datosPersonas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
   
   public void leer(){
        try
        {
            FileInputStream fis = new FileInputStream("datosPersonas");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            list = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
         
        //Verify list data
        for (Registro regis : list) {
            System.out.println(regis);
        }
    }
    
}

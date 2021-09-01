/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;

/**
 *
 * @author juice
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class Reversestring implements Serializable{
    String frase1, frase2;
    int caso;
    ArrayList<Reversestring> frases;
    
    public Reversestring(){
        frases = new ArrayList<>();
    }
    
    public Reversestring(String frase1, String frase2){
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    public String getFrase1() {
        return frase1;
    }

    public void setFrase1(String frase1) {
        this.frase1 = frase1;
    }

    public String getFrase2() {
        return frase2;
    }

    public void setFrase2(String frase2) {
        this.frase2 = frase2;
    }

    public ArrayList<Reversestring> getFrases() {
        return frases;
    }

    public void setFrases(ArrayList<Reversestring> frases) {
        this.frases = frases;
    }

    public int getCaso() {
        return caso;
    }

    public void setCaso(int caso) {
        this.caso = caso;
    }
    
    
    @Override
    public String toString() {
        return ("\n"+"************"+"\n"+"Case #"+this.getCaso()+": "+this.getFrase2());
   }
   
    public void recuperar(String frase2, int caso){
       setFrase2(frase2);
        setCaso(caso);
       agregar();
   }
    
    public void agregar(){
       Reversestring frasesita = new Reversestring();
       frasesita.setFrase2(frase2);
       frasesita.setCaso(caso+frases.size());
       frases.add(frasesita);
   }
    
    public void serializar(){
         try
        {
            FileOutputStream fos = new FileOutputStream("datosPersonas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(frases);
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
 
            frases = (ArrayList) ois.readObject();
 
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
        for (Reversestring frasesita : frases) {
            System.out.println(frasesita);
        }
    }
    
    // Metodo para revertir el string
    public void reverseWords(String str)
    {
  
        // Especificar el patron
        Pattern pattern = Pattern.compile("\\s");
  
        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        String result = "";
  
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1){
                result = temp[i] + result;
                setFrase2(result);
            }
            else{
                result = " " + temp[i] + result;
                setFrase2(result);
            }

        }
    }
    
    public void mostrar(){
       if(frases.isEmpty()){
           System.out.println("La lista esta vacia");
       }else{
           JOptionPane.showMessageDialog(null,frases);
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
               interf in = new interf();
               recuperar(frase2, caso);
               serializar();
           case 2:
               leer();
           case 3:
               mostrar();
       }
   }
  
    // Driver methods to test above method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        interf g = new interf();
        g.setVisible(true);
        g.setLocationRelativeTo(null);
    }
    
}

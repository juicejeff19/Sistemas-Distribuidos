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
import java.util.regex.Pattern;
public class Reversestring {
    String frase1, frase2;
    
    public Reversestring(){
        
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

import javax.swing.JOptionPane;

/**
 *
 * @author sala313
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        arbol A1= new arbol();
        char Vc[]=JOptionPane.showInputDialog("Ingrese la cadena del arbol").toCharArray();
        A1.insertar(Vc);
        //menu
    }  
        
     
    }
    
}

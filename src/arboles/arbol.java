package arboles;


import arboles.Nodo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sala313
 */
public class arbol {
    
    private Nodo raiz;

    public arbol() {
        raiz=null;
    }
    
    public void crear (char Vc[]){
        raiz= new Nodo(Vc[0]);
        Nodo p=raiz;
        
        for (int i = 1; i < Vc.length; i++) {
           
                Nodo nuevo=new Nodo(Vc[i]);
                if (nuevo.getDato()>p.getDato()) {
                    p.setLD(nuevo);
                
            }else{
                    if(nuevo.getDato()<p.getDato()){
                        p.setLI(nuevo);
                    }else{
                        
                    }
                
          
                
                
                
                
                
                
                
            }
            
        }
    }
}

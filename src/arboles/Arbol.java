package arboles;

import javax.swing.JOptionPane;

public class Arbol {

    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void Construir(char[] vc){

        for(char c : vc){

            if(Character.isLetter(c)){

                raiz = insertarRecursivo(raiz, c);
            }
        }
    }

    public Nodo insertarRecursivo(Nodo raiz, char dato){

        if(raiz == null){

            Nodo nuevo = new Nodo(dato);

         

            return nuevo;
        }

        if(dato < raiz.getDato()){

            raiz.setLI(
                insertarRecursivo(
                    raiz.getLI(),
                    dato
                )
            );
        }

        else if(dato > raiz.getDato()){

            raiz.setLD(
                insertarRecursivo(
                    raiz.getLD(),
                    dato
                )
            );
        }else{
            JOptionPane.showMessageDialog(null, "La letra " +dato+"ya fue ingresada");
        }
        

        return raiz;
    }
}

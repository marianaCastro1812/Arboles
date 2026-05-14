package arboles;

import javax.swing.JOptionPane;

public class Arbol {

    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }
    public int altura(Nodo nodo){

    if(nodo == null){
        return -1;
    }

    int izquierda =
        altura(nodo.getLI());

    int derecha =
        altura(nodo.getLD());

    return Math.max(izquierda, derecha) + 1;

}
    public int FactorB(Nodo nodo){

    int factor=altura(nodo.getLI())
            - altura(nodo.getLD());
        return factor;

    
}
    private Nodo RDD(Nodo raiz){
      

    raiz.setLI(

        RI(
            raiz.getLI()
        )
    );

    return RD(raiz);
}
    private Nodo RDI(Nodo raiz){
      

    raiz.setLD(

        RD(
            raiz.getLD()
        )
    );

    return RI(raiz);
}
    
    private Nodo RD(Nodo raiz){
       

    Nodo P = raiz.getLI();

    Nodo Q = P.getLD();

    P.setLD(raiz);

    raiz.setLI(Q);

    return P;
}
    private Nodo RI(Nodo raiz){
       

    Nodo P = raiz.getLD();

    Nodo Q = P.getLI();

    P.setLI(raiz);

    raiz.setLD(Q);

    return P;
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
        int factor = FactorB(raiz);

   if(factor > 1){

    System.out.println(
        "Desbalance izquierda en "
        + raiz.getDato()
    );if(FactorB(raiz.getLI()) >= 0){
    return RD(raiz);}else{
        return RDD(raiz);
    }
}
//Falta todo
if(factor < -1){

    System.out.println(
        "Desbalance derecha en "
        + raiz.getDato()
    ); if(FactorB(raiz.getLD()) <= 0){
    return RI(raiz);
    }else{
        return RDI(raiz);
}
} 

        return raiz;
    }
}

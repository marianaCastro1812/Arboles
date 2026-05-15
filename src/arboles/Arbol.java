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
      
//E

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
//    public void contaryMostrar(Nodo raiz, char dato){
//        contardescendientes(this.buscarNodo(raiz, dato));
//        Mostrardescendientes(this.buscarNodo(raiz, dato));
//        
//    }
      public int contardescendientes(Nodo raiz){

    if(raiz == null){

        return 0;
    }
    int cont=0;
    if (raiz.getLI() != null) {
        cont+=1;
    }

    if (raiz.getLD() != null) {
        cont+=1;
    }
    cont+=contardescendientes(raiz.getLI());
    cont+=contardescendientes(raiz.getLD());


//JOptionPane.showMessageDialog(null, "Hay " + cont + " descendientes "  );
  

    return
        cont;
}  
     public String Mostrardescendientes(Nodo raiz){

    if(raiz == null){

        return "";
    }
    String salida="";
    if (raiz.getLI() != null) {
        salida += raiz.getLI().getDato() + " ";
    }

    if (raiz.getLD() != null) {
        salida += raiz.getLD().getDato() + " ";
    }
    salida+=Mostrardescendientes(raiz.getLI());
    salida+=Mostrardescendientes(raiz.getLD());



    //JOptionPane.showMessageDialog(null, salida  );

    return
        salida;
}  
    
public int contarHojas(Nodo raiz){

    if(raiz == null){

        return 0;
    }

  
    if(
        raiz.getLI() == null
        &&
        raiz.getLD() == null
    ){

        return 1;
    }

    return
        contarHojas(raiz.getLI())+contarHojas(raiz.getLD());
}
    public void Construir(char[] vc){

        for(char c : vc){

            if(Character.isLetter(c)){

                raiz = insertarRecursivo(raiz, c);
            }
        }
    }
    public String posOrden(Nodo raiz){

    if(raiz == null){

        return "";
    }

    return
        posOrden(raiz.getLI())
        +
        posOrden(raiz.getLD())
        +
        raiz.getDato() + "-> ";
}
    public String preOrden(Nodo raiz){

    if(raiz == null){

        return "";
    }

    return
        raiz.getDato() + "-> "
        +
        preOrden(raiz.getLI())
        +
        preOrden(raiz.getLD());
}
    public String InOrden(Nodo raiz){

    if(raiz == null){

        return "";
    }

    return
        
        
            InOrden(raiz.getLI())
        +
        raiz.getDato() + "-> "
        +
        InOrden(raiz.getLD());
}
    public int contarPadres(Nodo raiz){

    if(raiz == null){

        return 0;
    }
    if(
        raiz.getLI() != null
        ||
        raiz.getLD() != null
    ){

        return 1 + contarPadres(raiz.getLI() ) + contarPadres(raiz.getLD());
        }

    return 0;
}
    public Nodo buscarNodo(Nodo raiz, char dato){

    if(raiz == null){

        return null;
    }

    if(dato == raiz.getDato()){

        return raiz;
    }

    if(dato < raiz.getDato()){

        return buscarNodo(
            raiz.getLI(),
            dato
        );
    }

    else{

        return buscarNodo(
            raiz.getLD(),
            dato
        );
    }
}
    public Nodo descendientes(Nodo raiz,char dato){
        Nodo buscado= buscarNodo(raiz, dato);
        
        return raiz;
    }
    public Nodo eliminar(Nodo raiz, char dato){

    if(raiz == null){
        JOptionPane.showMessageDialog(null, "Su letra no existe en el Arbol");
        return null;
    }



    if(dato < raiz.getDato()){

        raiz.setLI(

            eliminar(
                raiz.getLI(),
                dato
            )
        );
    }

    else if(dato > raiz.getDato()){

        raiz.setLD(

            eliminar(
                raiz.getLD(),
                dato
            )
        );
    }

    else{


        if(
            raiz.getLI() == null
            &&
            raiz.getLD() == null
        ){

            return null;
        }
        if(raiz.getLI() == null){

            return raiz.getLD();
        }

        if(raiz.getLD() == null){

            return raiz.getLI();
        }

        Nodo reemplazo =
            menorDerecha(
                raiz.getLD()
            );

        raiz.setDato(
            reemplazo.getDato()
        );

        raiz.setLD(

            eliminar(
                raiz.getLD(),
                reemplazo.getDato()
            )
        );
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
   

if(factor < -1){

    System.out.println(
        "Desbalance derecha en "
        + raiz.getDato()
    ); if(FactorB(raiz.getLD()) <= 0){
    return RI(raiz);
    }else{
        return RDI(raiz);
}}

    
    

    return raiz;
}
    public Nodo menorDerecha(Nodo nodo){

    while(nodo.getLI() != null){

        nodo = nodo.getLI();
    }

    return nodo;
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
            JOptionPane.showMessageDialog(null, "La letra " +dato+" ya fue ingresada");
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
    
    public Nodo mostrarHermano(Nodo raiz, char dato){

    if(raiz == null){
        return null;
    }


    if(
        raiz.getLI() != null &&
        raiz.getLI().getDato() == dato
    ){

        return raiz.getLD();
    }

    if(
        raiz.getLD() != null &&
        raiz.getLD().getDato() == dato
    ){

        return raiz.getLI();
    }

    Nodo izquierda =
        mostrarHermano(
            raiz.getLI(),
            dato
        );

    if(izquierda != null){
        return izquierda;
    }

    return mostrarHermano(
        raiz.getLD(),
        dato
    );
}
    
    public int mostrarNivel(Nodo raiz, char dato, int nivel){

    if(raiz == null){

        return -1;
    }

    if(raiz.getDato() == dato){

        return nivel;
    }

    int izquierda =
        mostrarNivel(
            raiz.getLI(),
            dato,
            nivel + 1
        );

    if(izquierda != -1){

        return izquierda;
    }

    return mostrarNivel(
        raiz.getLD(),
        dato,
        nivel + 1
    );
}
    
    public Nodo buscarPadre(Nodo raiz, char dato){

    if(raiz == null){

        return null;
    }

    if(
        (raiz.getLI() != null &&
        raiz.getLI().getDato() == dato)

        ||

        (raiz.getLD() != null &&
        raiz.getLD().getDato() == dato)
    ){

        return raiz;
    }

    Nodo izquierda =
        buscarPadre(
            raiz.getLI(),
            dato
        );

    if(izquierda != null){

        return izquierda;
    }

    return buscarPadre(
        raiz.getLD(),
        dato
    );
}
    
    public String mostrarPrimosHermanos(Nodo raiz, char dato){

    Nodo padre =
        buscarPadre(
            raiz,
            dato
        );

    if(padre == null){

        return "No tiene primos hermanos";
    }

    Nodo abuelo =
        buscarPadre(
            raiz,
            padre.getDato()
        );

    if(abuelo == null){

        return "No tiene primos hermanos";
    }

    Nodo tio = null;

    // Buscar el tio
    if(
        abuelo.getLI() != null &&
        abuelo.getLI().getDato() == padre.getDato()
    ){

        tio = abuelo.getLD();
    }

    else{

        tio = abuelo.getLI();
    }

    if(tio == null){

        return "No tiene primos hermanos";
    }

    String primos = "";

    if(tio.getLI() != null){

        primos +=
            tio.getLI().getDato()
            + " ";
    }

    if(tio.getLD() != null){

        primos +=
            tio.getLD().getDato()
            + " ";
    }

    if(primos.equals("")){

        return "No tiene primos hermanos";
    }

    return primos;
}
    public String mostrarAncestros(Nodo raiz, char dato){

    if(raiz == null){

        return "";
    }

    // Si el dato está en un hijo directo
    if(
        (raiz.getLI() != null &&
        raiz.getLI().getDato() == dato)

        ||

        (raiz.getLD() != null &&
        raiz.getLD().getDato() == dato)
    ){

        return raiz.getDato() + " ";
    }

    // Buscar por izquierda
    String izquierda =
        mostrarAncestros(
            raiz.getLI(),
            dato
        );

    if(!izquierda.equals("")){

        return raiz.getDato() + " " + izquierda;
    }

    // Buscar por derecha
    String derecha =
        mostrarAncestros(
            raiz.getLD(),
            dato
        );

    if(!derecha.equals("")){

        return raiz.getDato() + " " + derecha;
    }

    return "";
}
    //holamundo
}
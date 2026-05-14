package arboles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author  Mariana Castro y Miguel Angel Mejia
 */
public class Nodo {
    private Nodo LI, LD;
    private char Dato;
    private int altura;

    public Nodo (char Dato) {
        this.LI = null;
        this.LD = null;
        this.Dato = Dato;
        
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Nodo getLI() {
        return LI;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public char getDato() {
        return Dato;
    }

    public void setDato(char Dato) {
        this.Dato = Dato;
    }
    
    
    
    
    
}

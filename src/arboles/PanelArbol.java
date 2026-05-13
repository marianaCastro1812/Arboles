package arboles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;




public class PanelArbol extends JPanel {

    Arbol arbol;

    public PanelArbol(Arbol arbol) {

        this.arbol = arbol;
        this.setBackground(new Color(230,240,255));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        dibujar(g, arbol.getRaiz(), 400, 50, 200);
    }

    public void dibujar(Graphics g,
                         Nodo nodo,
                         int x,
                         int y,
                         int separacion) {

        if(nodo == null){
            return;
        }

        g.setColor(Color.DARK_GRAY);

        if(nodo.getLI() != null){

            g.drawLine(
                x + 20,
                y + 40,
                x - separacion + 20,
                y + 80
            );

            dibujar(
                g,
                nodo.getLI(),
                x - separacion,
                y + 80,
                separacion / 2
            );
        }

        if(nodo.getLD() != null){

            g.drawLine(
                x + 20,
                y + 40,
                x + separacion + 20,
                y + 80
            );

            dibujar(
                g,
                nodo.getLD(),
                x + separacion,
                y + 80,
                separacion / 2
            );
        }

        // ------------------------
        // NODO
        // ------------------------

        // Color del círculo
        g.setColor(new Color(102,153,255));

        // Círculo relleno
        g.fillOval(x, y, 40, 40);

        // Borde
        g.setColor(Color.BLACK);

        g.drawOval(x, y, 40, 40);

        
        g.setColor(Color.WHITE);

        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString(
            String.valueOf(nodo.getDato()),
            x + 13,
            y + 25
        );
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Modelo.ArbolBinario;
import Modelo.NodoDoble;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sofito-Chan
 */
public class Lienzo extends JPanel {
    private ArbolBinario arbol = new ArbolBinario();
    public static final int DIAMETRO = 26;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 35;

    public void setArbol(ArbolBinario arbol) {
        this.arbol = arbol;
        setBackground(Color.white);
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        pintar(g, getWidth()/2, 10, arbol.getRaiz());
    }
    
    private void pintar(Graphics g, int x, int y, NodoDoble n){
        if(n != null){
            int EXTRA = n.nodoCompletos() * (ANCHO/2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.retornaDato().toString(), x + 9, y + 18);
            if (n.retornaLI() != null){
                g.drawLine(x + RADIO, y + DIAMETRO, x - ANCHO - EXTRA + RADIO, y + ANCHO);
            }
            if (n.retornaLD() != null){
                g.drawLine(x + RADIO, y + DIAMETRO, x + ANCHO + EXTRA + RADIO, y + ANCHO);
            }
            pintar(g,x - ANCHO - EXTRA, y + ANCHO, n.retornaLI());
            pintar(g,x + ANCHO + EXTRA, y + ANCHO, n.retornaLD());
        }
    }
}

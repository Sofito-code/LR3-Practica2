/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ArbolControlador;
import Modelo.ArbolBinario;
import javax.swing.JFrame;

/**
 *
 * @author Sofito-Chan
 */
public class App2 {
    public static void main(String[] args) {
        // TODO code application logic here
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //PATRON MVC
        ArbolBinario a = new ArbolBinario(); //MODELO
        a.ConstruyeArbolBinario1(10, true);
        Lienzo l = new Lienzo(); //VISTA
        ArbolControlador objControlador = new ArbolControlador(a,l); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        // PINTAR ARBOL
        
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(l);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lr3.practica2;

import Modelo.*;
import java.util.*;

/**
 *
 * @author Sofito-Chan
 */
public class practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ArbolBinario test= new ArbolBinario();
        String a = "G,H,O,Q,R,T,X";
        String b = "H,O,R,Q,X,T,G";
//        test.CArbolBinario(a, 3);
//        int c=test.hojas();
//        System.out.print("ok");

        ArbolBinario A = new ArbolBinario();
        //A.ConstruyeArbolBinario(7, true);
        A.ConstruyeArbolBinario2(a);
        //A.construyeInPos(a, b);
        A.mostrar(0,A.getRaiz());
        A.mostrar(2,A.getRaiz());
        //A.altura();

    }

}

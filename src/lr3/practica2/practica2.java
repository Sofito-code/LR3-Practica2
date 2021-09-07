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
        String a="A,B,C,D,F,G";
//        test.CArbolBinario(a, 3);
//        int c=test.hojas();
//        System.out.print("ok");
        
        ArbolBinario A = new ArbolBinario();
        A.CArbolBinario(a, 3);
        A.mostrar(0);
        A.altura();
       
        NodoDoble x=A.buscarNodo("A");
        List c=A.ancestros(x);
    }

        
    }
    


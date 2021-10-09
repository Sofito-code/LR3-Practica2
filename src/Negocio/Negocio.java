/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sofito-Chan
 */
public class Negocio {
    
    public boolean verificarCantidadNodos(int n){
        if(n > 0 && n <= 25){
            return true;
        }
        return false;        
    }
    
    public boolean verificarLongitud(String x){
        Queue<String> cola = new LinkedList();
        cola.addAll(Arrays.asList(x.split(",")));
        if (cola.size() >= 25){
            return true;
        }
        return false;
    }
    
}
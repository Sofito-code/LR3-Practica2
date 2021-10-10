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
 * Esta clase se encarga de verificar que el usuario ingrese correctamente las credenciales.
 * 
 * @author Sofito-Chan
 * @author JohnDRD
 */
public class ArbolNegocio {

    /**
     * Verifica que el usuario ingrese un número entero entre 1 y 20.
     * 
     * @param n es el número ingresado por el usuario.
     * @return true si cumple con el rango numérico o false si no cumple.
     */
    public boolean verificarCantidadNodos(int n) {
        if (n > 0 && n <= 20) {
            return true;
        }
        return false;
    }

    /**
     * Verifica que el usuario ingrese un String con una longitud menor que 20.
     * 
     * @param x es un String ingresado por el usuario.
     * @return true si cumple con la longitud pedida o false si no cumple.
     */
    public boolean verificarLongitud(String x) {
        Queue<String> cola = new LinkedList();
        cola.addAll(Arrays.asList(x.split(",")));
        if (cola.size() >= 20) {
            return true;
        }
        return false;
    }

    /**
     * Verifica que el usuario ingrese dos strings de la misma longitud.
     * 
     * @param s1 es un String de un árbol delimitado por comas.
     * @param s2 es un String de un árbol delimitado por comas.
     * @return true si cumple con que ambos Strings tienen la misma longitud o false si no cumple.
     */
    public boolean verificarLongitud(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return true;
        }
        return false;
    }
}

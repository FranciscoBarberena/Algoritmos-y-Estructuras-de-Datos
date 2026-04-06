/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio9;

import java.util.Stack;

/**
 *
 * @author Alejandra
 */
public class TestBalanceo {

    public boolean isBalanced(String expression) {
        Stack<Character> pila = new Stack<>();
        Character elem;
        for (int i = 0; i < expression.length(); i++) {
            elem = expression.charAt(i);
            if ((elem == '(') ||( elem == '[' )||(elem == '{')){
                pila.push(elem);
            }
            else{
                if (pila.isEmpty())
                    return false;
                char ultimo = pila.pop();
                if ((elem == ')') && (ultimo != '('))
                    return false;
                if ((elem == ']') && (ultimo != '['))
                    return false;
                if ((elem == '}') && (ultimo != '{'))
                    return false;
            }
    }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String TU = "(()){[}";
        TestBalanceo t = new TestBalanceo();
        System.out.println(t.isBalanced(TU));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Doutriem Pro
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        String searchedWord;
        int [] vIndexNumberOfDeadKittens; 
        
        System.out.println("================= ENTRADA DE DADOS =================\n");
        System.out.println("Qual palavras deseja buscar? ");
        searchedWord  = entrada.nextLine();
        System.out.println("----------------------------------------------------\n");
        
        vIndexNumberOfDeadKittens =  findIndexInTheDictionary.getIndex(searchedWord);
        
        System.out.println("================ RESULTADO DA BUSCA   ==============\n");
        System.out.printf(
            "Indice = " + vIndexNumberOfDeadKittens[0] + "\n" +
            "Número de gatinhos mortos = " + vIndexNumberOfDeadKittens[1] +"\n");
        System.out.println("====================================================\n");
    }    
}

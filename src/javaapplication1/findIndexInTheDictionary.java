/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Doutriem Pro
 */
public class findIndexInTheDictionary {
    private static final int HTTP_COD_SUCESSO     = 200;
    private static final int HTTP_COD_BAD_REQUEST = 400;
    private static int returnFunction[]     = new int[2];
    
           
    
    public static int[] getIndex(String searchedWord) throws IOException{
        try {
            boolean encontrado = false;
            int index               = -1;
            int numberOfDeadKittens = 0;
            
            returnFunction[0] = index;
            returnFunction[1] = numberOfDeadKittens;
            
            while(!encontrado){
                index++;
                
                URL url = new URL("http://testes.ti.lemaf.ufla.br/api/Dicionario/"+index);
                numberOfDeadKittens++;                
                returnFunction[1] = numberOfDeadKittens;
                
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

                String retornoJson = bufferedReader.readLine();

                if (con.getResponseCode() != HTTP_COD_SUCESSO) {
                    if (con.getResponseCode() == HTTP_COD_BAD_REQUEST) {                         
                        throw new RuntimeException("A palavra " + searchedWord + " não foi encontrada no Dicionário!");                     
                    }else{    
                        throw new RuntimeException("HTTP error code : "+ con.getRequestMethod());
                    }    
                }else if(retornoJson.equals(searchedWord)){
                    returnFunction[0] = index;
                    encontrado = true;
                }else if(retornoJson.equals("\"Message\":\"The request is invalid.\"")){
                    throw new RuntimeException("A palavra " + searchedWord + " não foi encontrada no Dicionário!");
                }
                
                con.disconnect();
            }
            return returnFunction;           
           
        } catch (IOException | RuntimeException e) {                    
            return returnFunction;
        }       
    }    
}

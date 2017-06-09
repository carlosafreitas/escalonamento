/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Carlos
 */
public class Processos {
    
    ArrayList<Processo> processos = new ArrayList<Processo> ();

    public Processos() {
    }
    
    public int LerArq(){
        int contador = 0;
        try{
           BufferedReader br = new BufferedReader(new FileReader("c:/arquivo.txt"));
           while(br.ready()){
               contador++;
               String linha = br.readLine();
               Processo processo = new Processo();
               processo.setTempoCPU(Integer.parseInt(linha));
               processos.add(processo);
               System.out.println(linha);
           }
           br.close();
        }catch(IOException ioe){
           ioe.printStackTrace();
        }
        return contador;
    }
}

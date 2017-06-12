/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

/**
 *
 * @author Carlos
 */
public class Processos {
    
    ArrayList<Processo> processos = new ArrayList<Processo> ();

    public Processos() {
    }
    
    public int lerArq(){
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
    
    public void calcFifo(){

        int turnAround = 0;
        int espera = 0;
        int ProcAnterior = 0;
        int somaEspera = 0;
        int somaTurnAround = 0;

        for(int proc = 0; proc < processos.size(); proc++){
            Processo processo = processos.get(proc);
            espera += ProcAnterior;
            turnAround += processo.getTempoCPU();
            processo.setTempoEspera(espera);
            processo.setTempoTurnaround(turnAround);
            ProcAnterior = processo.getTempoCPU();
            
            somaEspera += processo.getTempoEspera();
            somaTurnAround += processo.getTempoTurnaround();
            
            System.out.println("Processo: "+ processo.getTempoCPU()+
                               " T : " + processo.getTempoTurnaround() +
                               " E : " + processo.getTempoEspera()            
            );
        }
        System.out.println("\nMedia dos tempos TurnAround: " + (float) somaTurnAround/processos.size());
        System.out.println("\nMedia dos tempos Espera: " + (float) somaEspera/processos.size());
    }

    void calcSJF() {

        //ArrayList sortProcessos = new ArrayList(processos);

        
        Collections.sort(processos);
        int turnAround = 0;
        int espera = 0;
        int ProcAnterior = 0;
        int somaEspera = 0;
        int somaTurnAround = 0;

        for(int proc = 0; proc < processos.size(); proc++){
            Processo processo = processos.get(proc);
            espera += ProcAnterior;
            turnAround += processo.getTempoCPU();
            processo.setTempoEspera(espera);
            processo.setTempoTurnaround(turnAround);
            ProcAnterior = processo.getTempoCPU();
            
            somaEspera += processo.getTempoEspera();
            somaTurnAround += processo.getTempoTurnaround();
            
            System.out.println("Processo: "+ processo.getTempoCPU()+
                               " T : " + processo.getTempoTurnaround() +
                               " E : " + processo.getTempoEspera()            
            );
        }
        System.out.println("\nMedia dos tempos TurnAround: " + (float) somaTurnAround/processos.size());
        System.out.println("\nMedia dos tempos Espera: " + (float) somaEspera/processos.size());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

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

    void calcRoundRobin() {
        int turnAround = 0;
        int espera = 0;
        int ProcAnterior = 0;
        int somaEspera = 0;
        int somaTurnAround = 0;
        int quantum = 0;
        int somaProcessos = 0;

        System.out.println("Por favor, informe o valor do Quantum: ");
        Scanner ler = new Scanner(System.in);
        quantum = ler.nextInt();
        
        int[] arrayProcesso = new int[processos.size()];
        for(int proc = 0; proc < processos.size(); proc++){
            Processo processo = processos.get(proc);
            arrayProcesso[proc] = processo.getTempoCPU();
            somaProcessos += processo.getTempoCPU();
            
        }
        
        int contaProcessos = 0;
        while(somaProcessos > contaProcessos){
        
            for(int proc = 0; proc < processos.size(); proc++){
                Processo processo = processos.get(proc);
                if (processo.getTempoTurnaround() == 0){
                    int qteprocesso = arrayProcesso[proc];
                    if (processo.getTempoEspera() == 0 && proc != 0){
                        processo.setTempoEspera(contaProcessos);
                        processos.set(proc, processo);
                    } 

                    if (qteprocesso > quantum){

                        arrayProcesso[proc] = arrayProcesso[proc] - quantum;
                        contaProcessos += quantum;

                    } else if (qteprocesso == quantum){

                        arrayProcesso[proc] = 0;
                        contaProcessos += quantum;
                        processo.setTempoTurnaround(contaProcessos);
                        processos.set(proc, processo);

                    } else if (qteprocesso < quantum){
                        contaProcessos += qteprocesso;
                        processo.setTempoTurnaround(contaProcessos);
                        arrayProcesso[proc] = 0;
                        processos.set(proc, processo);
                    }

                }
            }
            
        }
        
        for(int proc = 0; proc < processos.size(); proc++){
            Processo processo = processos.get(proc);
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

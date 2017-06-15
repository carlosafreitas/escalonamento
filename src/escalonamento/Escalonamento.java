/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Escalonamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Processos processos = new Processos();
        if (processos.lerArq() > 0){
            int n = 1;
            while ( n > 0){
                System.out.println("Cálculo de escalonamneto:\n");
                System.out.println("Por favor, selecione o processo:\n");
                System.out.println("1 - FIFO");
                System.out.println("2 - FPS");
                System.out.println("0 - sair");
                System.out.println("Por favor, selecione o processo: ");
                Scanner ler = new Scanner(System.in);
                n = ler.nextInt();
                switch (n){
                    case 1 :
                        processos.calcFifo();
                        break;
                    case 2 :
                        processos.calcSJF();
                        break;
                
                }
            }
        } else {
            System.out.println("Nenhum preocesso lido!");
        }
        
        
    }
    
}

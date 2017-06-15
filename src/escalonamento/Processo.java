/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento;

/**
 *
 * @author Carlos
 */
public class Processo implements Comparable<Processo>{
    private int tempoCPU;
    private int tempoTurnaround;
    private int tempoEspera;

    public int getTempoCPU() {
        return tempoCPU;
    }

    public void setTempoCPU(int tempoCPU) {
        this.tempoCPU = tempoCPU;
    }

    public int getTempoTurnaround() {
        return tempoTurnaround;
    }

    public void setTempoTurnaround(int tempoTurnaround) {
        this.tempoTurnaround = tempoTurnaround;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public int compareTo(Processo t) {

        if (this.tempoCPU < t.tempoCPU) {
            return -1;
        }
        if (this.tempoCPU > t.tempoCPU) {
            return 1;
        }
        return 0;
 
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

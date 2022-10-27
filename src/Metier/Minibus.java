/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author Enzou
 */
public class Minibus {
    private int numB;
    private int capacite;

    public int getNumB() {
        return numB;
    }

    public void setNumB(int numB) {
        this.numB = numB;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Minibus(int numB, int capacite) {
        this.numB = numB;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Minibus{" + "noMinibus=" + numB + ", capacite=" + capacite + "}\n";
    }
    
    
}

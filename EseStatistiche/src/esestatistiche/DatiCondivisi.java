/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mariani_luca
 */
public class DatiCondivisi {

    private int numSpaziInseriti;
    private int numSpaziLetti;
    private int numPuntiInseriti;
    private int numPuntiLetti;
    private int numCaratteri;
    private Semaphore semSpazi;
    private Semaphore semPunti;
    Vector<Character> vect = new Vector<Character>();

//    public DatiCondivisi() {
//        numSpaziInseriti = 0;
//        numSpaziLetti = 0;
//        numPuntiLetti = 0;
//        numPuntiInseriti = 0;
//        numCaratteri = 0;
//    }
    public DatiCondivisi(int numCaratteri) {
        this.numCaratteri = numCaratteri;
        numSpaziInseriti = 0;
        numSpaziLetti = 0;
        numPuntiLetti = 0;
        numPuntiInseriti = 0;
        semSpazi = new Semaphore(0);
        semPunti = new Semaphore(0);
    }

    public int getNumCaratteri() {
        return numCaratteri;
    }

    public Semaphore getSemSpazi() {
        return semSpazi;
    }

    public Semaphore getSemPunti() {
        return semPunti;
    }

    public int getNumPuntiInseriti() {
        return numPuntiInseriti;
    }

    public int getNumSpaziInseriti() {
        return numSpaziInseriti;
    }

    public int getNumSpaziLetti() {
        return numSpaziLetti;
    }

    public int getNumPuntiLetti() {
        return numPuntiLetti;
    }

    public void incNumSpaziLetti() {
        numSpaziLetti++;
    }

    public void incNumPuntiLetti() {
        numPuntiLetti++;
    }

    public void incNumSpaziInseriti() {
        numSpaziInseriti++;
    }

    public void incNumPuntiInseriti() {
        numPuntiInseriti++;
    }

    public void addChar(char carattere) {
        contaCaratteriExtra(carattere);
        vect.add(carattere);
    }

    public void contaCaratteriExtra(char carattere) {
        if (carattere == ' ') {
            incNumSpaziInseriti();
        }
        if (carattere == '.') {
            incNumPuntiInseriti();
        }
    }

    public String toString() {
        String ris = "";
        ris = "Punti inseriti: " + numPuntiInseriti
                + "Spazi inseriti: " + numSpaziInseriti
                + "Punti letti: " + numPuntiLetti
                + "Spazi letti: " + numSpaziLetti;
        return ris;
    }
}
